package com.baidu.util;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static LogUtil f23073a;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f23074c = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    public Context f23075b;

    public LogUtil(Context context) {
        this.f23075b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        LogUtil logUtil;
        synchronized (LogUtil.class) {
            if (f23073a == null) {
                f23073a = new LogUtil(context);
            }
            logUtil = f23073a;
        }
        return logUtil;
    }

    public static void logD(String str, String str2) {
        if (f23074c.booleanValue()) {
            Log.d(str, str2);
        }
    }

    public static void logE(String str, String str2) {
        if (f23074c.booleanValue()) {
            Log.e(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        if (f23074c.booleanValue()) {
            Log.i(str, str2);
        }
    }

    public static void syso(Boolean bool) {
        if (f23074c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        if (f23074c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        if (f23074c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        f23074c = Boolean.valueOf(z);
    }
}
