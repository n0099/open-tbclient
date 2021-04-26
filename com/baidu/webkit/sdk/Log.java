package com.baidu.webkit.sdk;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes5.dex */
public final class Log implements INoProGuard {
    public static String LOG_TAG = "ZeusLog";
    public static boolean sDebugApk = false;
    public static int sMinLogLevel = 4;

    public static int d(String str) {
        return printLog(3, LOG_TAG, str, null);
    }

    public static int d(String str, String str2) {
        return printLog(3, str, str2, null);
    }

    public static int d(String str, String str2, Throwable th) {
        return printLog(3, str, str2, th);
    }

    public static int d(String str, String str2, Object... objArr) {
        return printLogVargs(3, str, str2, objArr);
    }

    public static int e(String str) {
        return printLog(6, LOG_TAG, str, null);
    }

    public static int e(String str, String str2) {
        return printLog(6, str, str2, null);
    }

    public static int e(String str, String str2, Throwable th) {
        return printLog(6, str, str2, th);
    }

    public static int e(String str, String str2, Object... objArr) {
        return printLogVargs(6, str, str2, objArr);
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    public static int i(String str) {
        return printLog(4, LOG_TAG, str, null);
    }

    public static int i(String str, String str2) {
        return printLog(4, str, str2, null);
    }

    public static int i(String str, String str2, Throwable th) {
        return printLog(4, str, str2, th);
    }

    public static int i(String str, String str2, Object... objArr) {
        return printLogVargs(4, str, str2, objArr);
    }

    public static boolean isDebug() {
        return sDebugApk;
    }

    public static boolean isLoggable(String str, int i2) {
        return i2 >= sMinLogLevel && android.util.Log.isLoggable(str, i2);
    }

    public static int p(String str) {
        return printLog(6, LOG_TAG, str, null);
    }

    public static int p(String str, String str2) {
        return printLog(6, str, str2, null);
    }

    public static int p(String str, String str2, Throwable th) {
        return printLog(6, str, str2, th);
    }

    public static int printLog(int i2, String str, String str2, Throwable th) {
        if (i2 < sMinLogLevel) {
            return 0;
        }
        if (str == null) {
            str = LOG_TAG;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (th != null) {
            str2 = str2 + '\n' + android.util.Log.getStackTraceString(th);
        }
        switch (i2) {
            case 2:
                return android.util.Log.i(str, str2);
            case 3:
                return android.util.Log.i(str, str2);
            case 4:
                return android.util.Log.i(str, str2);
            case 5:
                return android.util.Log.w(str, str2);
            case 6:
            case 7:
                return android.util.Log.e(str, str2);
            default:
                return android.util.Log.e(str, str2);
        }
    }

    public static int printLogVargs(int i2, String str, String str2, Object... objArr) {
        if (i2 < sMinLogLevel) {
            return 0;
        }
        return printLog(i2, str, String.format(str2, objArr), null);
    }

    public static void printStackTrace(Throwable th) {
        if (sMinLogLevel < 6 || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void setMinLogLevel(int i2, boolean z) {
        String str = LOG_TAG;
        android.util.Log.e(str, "ZeusSDK.ZeusMinLogLevel=" + i2 + ", sDebugApk=" + z);
        if (i2 < 2 || i2 > 7) {
            return;
        }
        sMinLogLevel = i2;
        sDebugApk = z;
    }

    public static int v(String str) {
        return printLog(2, LOG_TAG, str, null);
    }

    public static int v(String str, String str2) {
        return printLog(2, str, str2, null);
    }

    public static int v(String str, String str2, Throwable th) {
        return printLog(2, str, str2, th);
    }

    public static int v(String str, String str2, Object... objArr) {
        return printLogVargs(2, str, str2, objArr);
    }

    public static int w(String str) {
        return printLog(5, LOG_TAG, str, null);
    }

    public static int w(String str, String str2) {
        return printLog(5, str, str2, null);
    }

    public static int w(String str, String str2, Throwable th) {
        return printLog(5, str, str2, th);
    }

    public static int w(String str, String str2, Object... objArr) {
        return printLogVargs(5, str, str2, objArr);
    }

    public static int w(String str, Throwable th) {
        return printLog(5, str, "", th);
    }

    public static int wtf(String str, String str2) {
        return printLog(6, str, str2, null);
    }

    public static int wtf(String str, String str2, Throwable th) {
        return printLog(6, str, str2, th);
    }

    public static int wtf(String str, Throwable th) {
        return printLog(6, str, "", th);
    }

    public static int wtfStack(String str, String str2) {
        return printLog(6, str, str2, null);
    }
}
