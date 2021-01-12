package com.baidu.ufosdk.f;
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f5386a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f5386a;
        if (0 >= j || j >= 500) {
            f5386a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
