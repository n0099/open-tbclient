package com.baidu.util;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static LogUtil f22959a;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f22960c = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    public Context f22961b;

    public LogUtil(Context context) {
        this.f22961b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        LogUtil logUtil;
        synchronized (LogUtil.class) {
            if (f22959a == null) {
                f22959a = new LogUtil(context);
            }
            logUtil = f22959a;
        }
        return logUtil;
    }

    public static void logD(String str, String str2) {
        if (f22960c.booleanValue()) {
            Log.d(str, str2);
        }
    }

    public static void logE(String str, String str2) {
        if (f22960c.booleanValue()) {
            Log.e(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        if (f22960c.booleanValue()) {
            Log.i(str, str2);
        }
    }

    public static void syso(Boolean bool) {
        if (f22960c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        if (f22960c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        if (f22960c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        f22960c = Boolean.valueOf(z);
    }
}
