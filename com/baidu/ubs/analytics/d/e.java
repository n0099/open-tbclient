package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cET() {
        return com.baidu.ubs.analytics.d.cEt().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void HP(String str) {
        cET().edit().putBoolean(str, true).apply();
    }

    public static boolean HQ(String str) {
        return cET().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cET().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cET().edit().putLong(str, j).apply();
    }

    public static long HR(String str) {
        return cET().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cET().edit().putString(str, str2).apply();
    }
}
