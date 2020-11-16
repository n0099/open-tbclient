package com.baidu.util;

import android.content.Context;
import android.util.Log;
/* loaded from: classes14.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static LogUtil f3896a;
    private static Boolean c = false;
    private Context b;

    private LogUtil(Context context) {
        this.b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        LogUtil logUtil;
        synchronized (LogUtil.class) {
            if (f3896a == null) {
                f3896a = new LogUtil(context);
            }
            logUtil = f3896a;
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
