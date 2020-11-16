package com.baidu.ufosdk.f;
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f3718a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f3718a;
        if (0 >= j || j >= 500) {
            f3718a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
