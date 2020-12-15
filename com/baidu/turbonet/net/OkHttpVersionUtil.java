package com.baidu.turbonet.net;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
/* loaded from: classes10.dex */
public class OkHttpVersionUtil {
    public static boolean ehF() throws RuntimeException {
        String ehG = ehG();
        if (ehG.isEmpty()) {
            throw new NoSuchElementException();
        }
        String[] split = ehG.split("/");
        if (split.length != 2) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", ehG));
        }
        String[] split2 = split[1].split("\\.");
        if (split2.length != 3) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", ehG));
        }
        try {
            if (Integer.parseInt(split2[0]) == 3) {
                if (Integer.parseInt(split2[1]) >= 9) {
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", ehG));
        }
    }

    private static String ehG() {
        if (ehH()) {
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

    private static boolean ehH() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
