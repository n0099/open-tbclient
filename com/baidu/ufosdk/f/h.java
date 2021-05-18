package com.baidu.ufosdk.f;
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static long f22596a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f22596a;
        if (0 >= j || j >= 500) {
            f22596a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
