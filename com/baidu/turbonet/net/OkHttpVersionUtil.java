package com.baidu.turbonet.net;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class OkHttpVersionUtil {
    public static boolean dvH() throws RuntimeException {
        String dvI = dvI();
        if (dvI.isEmpty()) {
            throw new NoSuchElementException();
        }
        String[] split = dvI.split("/");
        if (split.length != 2) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", dvI));
        }
        String[] split2 = split[1].split("\\.");
        if (split2.length != 3) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", dvI));
        }
        try {
            if (Integer.parseInt(split2[0]) == 3) {
                if (Integer.parseInt(split2[1]) >= 9) {
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", dvI));
        }
    }

    private static String dvI() {
        if (dvJ()) {
            try {
                return (String) Class.forName("okhttp3.internal.Version").getMethod("userAgent", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException e) {
                return "";
            } catch (IllegalAccessException e2) {
                return "";
            } catch (NoSuchMethodException e3) {
                return "";
            } catch (InvocationTargetException e4) {
                return "";
            }
        }
        return "";
    }

    private static boolean dvJ() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
