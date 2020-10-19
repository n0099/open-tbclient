package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public final class e {
    private static SharedPreferences dUz() {
        return com.baidu.ubs.analytics.d.dUa().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dUz().edit().putBoolean(str, true).apply();
    }

    public static boolean Vi(String str) {
        return dUz().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dUz().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dUz().edit().putLong(str, j).apply();
    }

    public static long Vj(String str) {
        return dUz().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dUz().edit().putString(str, str2).apply();
    }
}
