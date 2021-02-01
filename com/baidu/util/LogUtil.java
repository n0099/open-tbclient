package com.baidu.util;

import android.content.Context;
import android.util.Log;
/* loaded from: classes3.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static LogUtil f5623a;
    private static Boolean c = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f5624b;

    private LogUtil(Context context) {
        this.f5624b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        LogUtil logUtil;
        synchronized (LogUtil.class) {
            if (f5623a == null) {
                f5623a = new LogUtil(context);
            }
            logUtil = f5623a;
        }
        return logUtil;
    }

    public static void logD(String str, String str2) {
        if (c.booleanValue()) {
            Log.d(str, str2);
        }
    }

    public static void logE(String str, String str2) {
        if (c.booleanValue()) {
            Log.e(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        if (c.booleanValue()) {
            Log.i(str, str2);
        }
    }

    public static void syso(Boolean bool) {
        if (c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        if (c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        if (c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        c = Boolean.valueOf(z);
    }
}
