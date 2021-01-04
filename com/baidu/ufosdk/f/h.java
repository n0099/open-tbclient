package com.baidu.ufosdk.f;
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f5668a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f5668a;
        if (0 >= j || j >= 500) {
            f5668a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
