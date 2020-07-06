package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dxG() {
        return com.baidu.ubs.analytics.d.dxh().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dxG().edit().putBoolean(str, true).apply();
    }

    public static boolean Qh(String str) {
        return dxG().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dxG().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dxG().edit().putLong(str, j).apply();
    }

    public static long Qi(String str) {
        return dxG().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dxG().edit().putString(str, str2).apply();
    }
}
