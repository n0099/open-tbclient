package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cBE() {
        return com.baidu.ubs.analytics.d.cBb().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Gg(String str) {
        cBE().edit().putBoolean(str, true).apply();
    }

    public static boolean Gh(String str) {
        return cBE().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cBE().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cBE().edit().putLong(str, j).apply();
    }

    public static long Gi(String str) {
        return cBE().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cBE().edit().putString(str, str2).apply();
    }
}
