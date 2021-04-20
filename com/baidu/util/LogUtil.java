package com.baidu.util;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static LogUtil f22993a;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f22994c = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    public Context f22995b;

    public LogUtil(Context context) {
        this.f22995b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        LogUtil logUtil;
        synchronized (LogUtil.class) {
            if (f22993a == null) {
                f22993a = new LogUtil(context);
            }
            logUtil = f22993a;
        }
        return logUtil;
    }

    public static void logD(String str, String str2) {
        if (f22994c.booleanValue()) {
            Log.d(str, str2);
        }
    }

    public static void logE(String str, String str2) {
        if (f22994c.booleanValue()) {
            Log.e(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        if (f22994c.booleanValue()) {
            Log.i(str, str2);
        }
    }

    public static void syso(Boolean bool) {
        if (f22994c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        if (f22994c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        if (f22994c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        f22994c = Boolean.valueOf(z);
    }
}
