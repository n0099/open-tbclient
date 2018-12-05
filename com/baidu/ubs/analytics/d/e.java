package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences bSe() {
        return com.baidu.ubs.analytics.d.bRJ().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void yC(String str) {
        bSe().edit().putBoolean(str, true).apply();
    }

    public static boolean yD(String str) {
        return bSe().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return bSe().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        bSe().edit().putLong(str, j).apply();
    }

    public static long yE(String str) {
        return bSe().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        bSe().edit().putString(str, str2).apply();
    }
}
