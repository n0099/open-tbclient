package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public final class e {
    private static SharedPreferences ear() {
        return com.baidu.ubs.analytics.d.dZS().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        ear().edit().putBoolean(str, true).apply();
    }

    public static boolean Ww(String str) {
        return ear().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return ear().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        ear().edit().putLong(str, j).apply();
    }

    public static long Wx(String str) {
        return ear().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        ear().edit().putString(str, str2).apply();
    }
}
