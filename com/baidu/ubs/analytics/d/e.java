package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class e {
    private static SharedPreferences dMQ() {
        return com.baidu.ubs.analytics.d.dMr().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dMQ().edit().putBoolean(str, true).apply();
    }

    public static boolean TS(String str) {
        return dMQ().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dMQ().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dMQ().edit().putLong(str, j).apply();
    }

    public static long TT(String str) {
        return dMQ().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dMQ().edit().putString(str, str2).apply();
    }
}
