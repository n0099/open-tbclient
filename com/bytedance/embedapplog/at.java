package com.bytedance.embedapplog;
/* loaded from: classes4.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5783a;

    /* renamed from: b  reason: collision with root package name */
    private static long f5784b = 0;
    private static long c = 0;

    public static long a() {
        return System.currentTimeMillis() / 86400000;
    }

    public static void b() {
        f5784b++;
        au.a("addFailedCount " + f5784b, null);
    }

    public static boolean c() {
        au.a("canSave " + f5783a, null);
        return f5783a;
    }

    public static boolean d() {
        boolean z = f5784b < 3 && a() != c && f5783a;
        au.a("canSend " + z, null);
        return z;
    }

    public static void e() {
        c = a();
        au.a("setSendFinished " + c, null);
    }

    public static void a(boolean z) {
        f5783a = z;
    }
}
