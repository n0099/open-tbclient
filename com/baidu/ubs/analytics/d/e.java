package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class e {
    private static SharedPreferences dQO() {
        return com.baidu.ubs.analytics.d.dQp().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dQO().edit().putBoolean(str, true).apply();
    }

    public static boolean Uu(String str) {
        return dQO().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dQO().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dQO().edit().putLong(str, j).apply();
    }

    public static long Uv(String str) {
        return dQO().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dQO().edit().putString(str, str2).apply();
    }
}
