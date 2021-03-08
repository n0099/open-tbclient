package com.baidu.ufosdk.f;
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static long f3624a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f3624a;
        if (0 >= j || j >= 500) {
            f3624a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
