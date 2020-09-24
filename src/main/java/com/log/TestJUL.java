package com.log;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestJUL {
	private static Logger logger = Logger.getLogger(TestJUL.class.getName());

	public static void main(String[] args) {

		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("E:\\test.log", true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SimpleFormatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);

		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(formatter);

		logger.addHandler(fileHandler);
		logger.addHandler(consoleHandler);

		logger.setLevel(Level.WARNING);
		logger.log(Level.FINE, "Fine日志信息");
		logger.log(Level.CONFIG, "Config日志信息");
		logger.log(Level.INFO, "Info日志信息");
		logger.log(Level.WARNING, "Warin警告信息");
		logger.log(Level.SEVERE, "SERVER信息");
	}
}
