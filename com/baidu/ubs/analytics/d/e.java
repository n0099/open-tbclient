package com.baidu.ubs.analytics.d;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class e {
    private static SharedPreferences dsL() {
        return com.baidu.ubs.analytics.d.dsk().getContext().getSharedPreferences("baidu_ab_general_config", 0);
    }

    public static void J(String str) {
        dsL().edit().putBoolean(str, true).apply();
    }

    public static boolean Pt(String str) {
        return dsL().getBoolean(str, false);
    }

    public static String c(String str, String str2) {
        return dsL().getString(str, str2);
    }

    public static void putLong(String str, long j) {
        dsL().edit().putLong(str, j).apply();
    }

    public static long Pu(String str) {
        return dsL().getLong(str, 0L);
    }

    public static void d(String str, String str2) {
        dsL().edit().putString(str, str2).apply();
    }
}
