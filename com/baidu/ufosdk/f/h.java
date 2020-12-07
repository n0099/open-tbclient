package com.baidu.ufosdk.f;
/* loaded from: classes22.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f3721a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f3721a;
        if (0 >= j || j >= 500) {
            f3721a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
