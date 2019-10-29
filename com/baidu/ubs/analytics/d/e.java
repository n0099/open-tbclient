package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cBG() {
        return com.baidu.ubs.analytics.d.cBd().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Gg(String str) {
        cBG().edit().putBoolean(str, true).apply();
    }

    public static boolean Gh(String str) {
        return cBG().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cBG().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cBG().edit().putLong(str, j).apply();
    }

    public static long Gi(String str) {
        return cBG().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cBG().edit().putString(str, str2).apply();
    }
}
