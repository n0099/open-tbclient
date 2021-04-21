package com.baidu.util;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static LogUtil f23001a;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f23002c = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    public Context f23003b;

    public LogUtil(Context context) {
        this.f23003b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        LogUtil logUtil;
        synchronized (LogUtil.class) {
            if (f23001a == null) {
                f23001a = new LogUtil(context);
            }
            logUtil = f23001a;
        }
        return logUtil;
    }

    public static void logD(String str, String str2) {
        if (f23002c.booleanValue()) {
            Log.d(str, str2);
        }
    }

    public static void logE(String str, String str2) {
        if (f23002c.booleanValue()) {
            Log.e(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        if (f23002c.booleanValue()) {
            Log.i(str, str2);
        }
    }

    public static void syso(Boolean bool) {
        if (f23002c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        if (f23002c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        if (f23002c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        f23002c = Boolean.valueOf(z);
    }
}
