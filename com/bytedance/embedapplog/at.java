package com.bytedance.embedapplog;
/* loaded from: classes4.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6082a;

    /* renamed from: b  reason: collision with root package name */
    private static long f6083b = 0;
    private static long c = 0;

    public static long a() {
        return System.currentTimeMillis() / 86400000;
    }

    public static void b() {
        f6083b++;
        au.a("addFailedCount " + f6083b, null);
    }

    public static boolean c() {
        au.a("canSave " + f6082a, null);
        return f6082a;
    }

    public static boolean d() {
        boolean z = f6083b < 3 && a() != c && f6082a;
        au.a("canSend " + z, null);
        return z;
    }

    public static void e() {
        c = a();
        au.a("setSendFinished " + c, null);
    }

    public static void a(boolean z) {
        f6082a = z;
    }
}
