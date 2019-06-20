package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cAL() {
        return com.baidu.ubs.analytics.d.cAm().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Gu(String str) {
        cAL().edit().putBoolean(str, true).apply();
    }

    public static boolean Gv(String str) {
        return cAL().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cAL().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cAL().edit().putLong(str, j).apply();
    }

    public static long Gw(String str) {
        return cAL().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cAL().edit().putString(str, str2).apply();
    }
}
