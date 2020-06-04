package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dsZ() {
        return com.baidu.ubs.analytics.d.dsy().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dsZ().edit().putBoolean(str, true).apply();
    }

    public static boolean Pu(String str) {
        return dsZ().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dsZ().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dsZ().edit().putLong(str, j).apply();
    }

    public static long Pv(String str) {
        return dsZ().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dsZ().edit().putString(str, str2).apply();
    }
}
