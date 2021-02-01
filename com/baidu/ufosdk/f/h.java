package com.baidu.ufosdk.f;
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f5388a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f5388a;
        if (0 >= j || j >= 500) {
            f5388a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
