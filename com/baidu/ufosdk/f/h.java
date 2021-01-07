package com.baidu.ufosdk.f;
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f5669a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f5669a;
        if (0 >= j || j >= 500) {
            f5669a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
