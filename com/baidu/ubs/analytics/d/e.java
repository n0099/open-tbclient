package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences cWB() {
        return com.baidu.ubs.analytics.d.cVY().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Lg(String str) {
        cWB().edit().putBoolean(str, true).apply();
    }

    public static boolean Lh(String str) {
        return cWB().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cWB().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cWB().edit().putLong(str, j).apply();
    }

    public static long Li(String str) {
        return cWB().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cWB().edit().putString(str, str2).apply();
    }
}
