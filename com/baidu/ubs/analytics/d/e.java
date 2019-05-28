package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class e {
    private static SharedPreferences cAM() {
        return com.baidu.ubs.analytics.d.cAn().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void Gs(String str) {
        cAM().edit().putBoolean(str, true).apply();
    }

    public static boolean Gt(String str) {
        return cAM().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return cAM().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        cAM().edit().putLong(str, j).apply();
    }

    public static long Gu(String str) {
        return cAM().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        cAM().edit().putString(str, str2).apply();
    }
}
