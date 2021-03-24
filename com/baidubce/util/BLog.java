package com.baidubce.util;

import android.util.Log;
/* loaded from: classes5.dex */
public class BLog {
    public static String LOG_TAG = "BOS";
    public static boolean enableLog;

    public static void debug(String str) {
        if (enableLog) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static void error(String str) {
        if (enableLog) {
            Log.e(LOG_TAG, String.valueOf(str));
        }
    }

    public static void info(String str) {
        if (enableLog) {
            Log.i(LOG_TAG, str);
        }
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    public static void warn(String str) {
        if (enableLog) {
            Log.w(LOG_TAG, String.valueOf(str));
        }
    }

    public static void debug(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.d(str2, str + obj);
        }
    }

    public static void error(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.e(str2, str + obj);
        }
    }

    public static void info(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.i(str2, str + obj);
        }
    }

    public static void warn(String str, Object obj) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.w(str2, str + obj);
        }
    }

    public static void debug(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.d(str2, str + obj + obj2);
        }
    }

    public static void error(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.e(str2, str + obj + obj2);
        }
    }

    public static void info(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.i(str2, str + obj + obj2);
        }
    }

    public static void warn(String str, Object obj, Object obj2) {
        if (enableLog) {
            String str2 = LOG_TAG;
            Log.w(str2, str + obj + obj2);
        }
    }

    public static void debug(String str, Throwable th) {
        if (enableLog) {
            Log.d(LOG_TAG, str, th);
        }
    }

    public static void error(String str, Throwable th) {
        if (enableLog) {
            Log.e(LOG_TAG, str, th);
        }
    }

    public static void info(String str, Throwable th) {
        if (enableLog) {
            Log.i(LOG_TAG, str, th);
        }
    }

    public static void warn(String str, Throwable th) {
        if (enableLog) {
            Log.w(LOG_TAG, str, th);
        }
    }

    public static void debug(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            Log.d(str3, str + str2, th);
        }
    }

    public static void error(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            Log.e(str3, str + str2, th);
        }
    }

    public static void info(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            Log.i(str3, str + str2, th);
        }
    }

    public static void warn(String str, String str2, Throwable th) {
        if (enableLog) {
            String str3 = LOG_TAG;
            Log.w(str3, str + str2, th);
        }
    }
}
