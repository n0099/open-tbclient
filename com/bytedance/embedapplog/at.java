package com.bytedance.embedapplog;
/* loaded from: classes4.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6083a;

    /* renamed from: b  reason: collision with root package name */
    private static long f6084b = 0;
    private static long c = 0;

    public static long a() {
        return System.currentTimeMillis() / 86400000;
    }

    public static void b() {
        f6084b++;
        au.a("addFailedCount " + f6084b, null);
    }

    public static boolean c() {
        au.a("canSave " + f6083a, null);
        return f6083a;
    }

    public static boolean d() {
        boolean z = f6084b < 3 && a() != c && f6083a;
        au.a("canSend " + z, null);
        return z;
    }

    public static void e() {
        c = a();
        au.a("setSendFinished " + c, null);
    }

    public static void a(boolean z) {
        f6083a = z;
    }
}
