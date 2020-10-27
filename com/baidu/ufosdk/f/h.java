package com.baidu.ufosdk.f;
/* loaded from: classes22.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f3716a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f3716a;
        if (0 >= j || j >= 500) {
            f3716a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
