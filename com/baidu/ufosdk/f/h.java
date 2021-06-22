package com.baidu.ufosdk.f;
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static long f22710a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f22710a;
        if (0 >= j || j >= 500) {
            f22710a = currentTimeMillis;
            return false;
        }
        return true;
    }
}
