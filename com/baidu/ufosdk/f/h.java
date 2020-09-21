package com.baidu.ufosdk.f;
/* loaded from: classes21.dex */
public final class h {
    private static long a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - a;
        if (0 >= j || j >= 500) {
            a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
