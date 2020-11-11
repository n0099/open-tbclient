package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public final class e {
    private static SharedPreferences edZ() {
        return com.baidu.ubs.analytics.d.edA().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        edZ().edit().putBoolean(str, true).apply();
    }

    public static boolean WZ(String str) {
        return edZ().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return edZ().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        edZ().edit().putLong(str, j).apply();
    }

    public static long Xa(String str) {
        return edZ().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        edZ().edit().putString(str, str2).apply();
    }
}
