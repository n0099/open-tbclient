package com.baidu.turbonet.net;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public class OkHttpVersionUtil {
    public static boolean egD() throws RuntimeException {
        String egE = egE();
        if (egE.isEmpty()) {
            throw new NoSuchElementException();
        }
        String[] split = egE.split("/");
        if (split.length != 2) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", egE));
        }
        String[] split2 = split[1].split("\\.");
        if (split2.length != 3) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", egE));
        }
        try {
            if (Integer.parseInt(split2[0]) == 3) {
                if (Integer.parseInt(split2[1]) >= 9) {
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", egE));
        }
    }

    private static String egE() {
        if (egF()) {
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

    private static boolean egF() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
