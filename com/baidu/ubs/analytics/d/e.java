package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cDK() {
        return com.baidu.ubs.analytics.d.cDk().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Ho(String str) {
        cDK().edit().putBoolean(str, true).apply();
    }

    public static boolean Hp(String str) {
        return cDK().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cDK().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cDK().edit().putLong(str, j).apply();
    }

    public static long Hq(String str) {
        return cDK().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cDK().edit().putString(str, str2).apply();
    }
}
