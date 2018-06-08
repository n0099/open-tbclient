package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class e {
    private static SharedPreferences bKn() {
        return com.baidu.ubs.analytics.d.bJP().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void wi(String str) {
        bKn().edit().putBoolean(str, true).apply();
    }

    public static boolean wj(String str) {
        return bKn().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bKn().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bKn().edit().putLong(str, j).apply();
    }

    public static long wk(String str) {
        return bKn().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bKn().edit().putString(str, str2).apply();
    }
}
