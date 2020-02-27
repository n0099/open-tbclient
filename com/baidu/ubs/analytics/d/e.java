package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences cXP() {
        return com.baidu.ubs.analytics.d.cXm().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Lt(String str) {
        cXP().edit().putBoolean(str, true).apply();
    }

    public static boolean Lu(String str) {
        return cXP().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cXP().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cXP().edit().putLong(str, j).apply();
    }

    public static long Lv(String str) {
        return cXP().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cXP().edit().putString(str, str2).apply();
    }
}
