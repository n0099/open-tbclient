package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dly() {
        return com.baidu.ubs.analytics.d.dkW().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dly().edit().putBoolean(str, true).apply();
    }

    public static boolean ND(String str) {
        return dly().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dly().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dly().edit().putLong(str, j).apply();
    }

    public static long NE(String str) {
        return dly().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dly().edit().putString(str, str2).apply();
    }
}
