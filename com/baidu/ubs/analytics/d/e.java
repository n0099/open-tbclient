package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dxC() {
        return com.baidu.ubs.analytics.d.dxd().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dxC().edit().putBoolean(str, true).apply();
    }

    public static boolean Qg(String str) {
        return dxC().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dxC().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dxC().edit().putLong(str, j).apply();
    }

    public static long Qh(String str) {
        return dxC().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dxC().edit().putString(str, str2).apply();
    }
}
