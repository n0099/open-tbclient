package com.baidu.turbonet.base;

import android.util.Log;
import java.util.Locale;
/* loaded from: classes6.dex */
public class a {
    private a() {
    }

    private static String formatLog(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            return String.format(Locale.US, str, objArr);
        }
        return str;
    }

    public static String normalizeTag(String str) {
        if (!str.startsWith("cr_")) {
            int i = 0;
            if (str.startsWith("cr.")) {
                i = "cr.".length();
            }
            return "cr_" + str.substring(i, str.length());
        }
        return str;
    }

    private static String g(String str, Object... objArr) {
        return "[" + efS() + "] " + formatLog(str, objArr);
    }

    private static void debug(String str, String str2, Object... objArr) {
        String g = g(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            Log.d(normalizeTag(str), g, throwableToLog);
        } else {
            Log.d(normalizeTag(str), g);
        }
    }

    public static void d(String str, String str2) {
        debug(str, str2, new Object[0]);
    }

    public static void i(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            Log.i(normalizeTag(str), formatLog, throwableToLog);
        } else {
            Log.i(normalizeTag(str), formatLog);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            Log.e(normalizeTag(str), formatLog, throwableToLog);
        } else {
            Log.e(normalizeTag(str), formatLog);
        }
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    private static String efS() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = a.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (!stackTrace[i].getClassName().equals(name)) {
                i++;
            } else {
                i += 4;
                break;
            }
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }
}
