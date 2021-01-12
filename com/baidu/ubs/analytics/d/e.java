package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences efY() {
        return com.baidu.ubs.analytics.d.efH().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        efY().edit().putBoolean(str, true).apply();
    }

    public static boolean WF(String str) {
        return efY().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return efY().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        efY().edit().putLong(str, j).apply();
    }

    public static long WG(String str) {
        return efY().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        efY().edit().putString(str, str2).apply();
    }
}
