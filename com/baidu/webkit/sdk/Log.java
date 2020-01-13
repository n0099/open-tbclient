package com.baidu.webkit.sdk;

import com.a.a.a.a.a.a.a;
import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes10.dex */
public final class Log implements INoProGuard {
    public static String LOG_TAG = "ZeusLog";
    private static boolean sDebugApk = false;
    private static int sMinLogLevel = 4;

    private Log() {
    }

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

    public static boolean isLoggable(String str, int i) {
        return i >= sMinLogLevel && android.util.Log.isLoggable(str, i);
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

    private static int printLog(int i, String str, String str2, Throwable th) {
        if (i < sMinLogLevel) {
            return 0;
        }
        if (str == null) {
            str = LOG_TAG;
        }
        String str3 = str2 == null ? "" : str2;
        if (th != null) {
            str3 = str3 + '\n' + android.util.Log.getStackTraceString(th);
        }
        switch (i) {
            case 2:
                return android.util.Log.i(str, str3);
            case 3:
                return android.util.Log.i(str, str3);
            case 4:
                return android.util.Log.i(str, str3);
            case 5:
                return android.util.Log.w(str, str3);
            case 6:
            case 7:
                return android.util.Log.e(str, str3);
            default:
                return android.util.Log.e(str, str3);
        }
    }

    private static int printLogVargs(int i, String str, String str2, Object... objArr) {
        if (i < sMinLogLevel) {
            return 0;
        }
        return printLog(i, str, String.format(str2, objArr), null);
    }

    public static void printStackTrace(Throwable th) {
        if ((th != null) && (sMinLogLevel >= 6)) {
            a.a(th);
        }
    }

    public static void setMinLogLevel(int i, boolean z) {
        android.util.Log.e(LOG_TAG, "ZeusSDK.ZeusMinLogLevel=" + i + ", sDebugApk=" + z);
        if (i < 2 || i > 7) {
            return;
        }
        sMinLogLevel = i;
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
