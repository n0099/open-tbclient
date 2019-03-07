package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences csA() {
        return com.baidu.ubs.analytics.d.csd().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void EX(String str) {
        csA().edit().putBoolean(str, true).apply();
    }

    public static boolean EY(String str) {
        return csA().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return csA().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        csA().edit().putLong(str, j).apply();
    }

    public static long EZ(String str) {
        return csA().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        csA().edit().putString(str, str2).apply();
    }
}
