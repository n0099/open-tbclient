package com.bytedance.embedapplog;
/* loaded from: classes6.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5785a;

    /* renamed from: b  reason: collision with root package name */
    private static long f5786b = 0;
    private static long c = 0;

    public static long a() {
        return System.currentTimeMillis() / 86400000;
    }

    public static void b() {
        f5786b++;
        au.a("addFailedCount " + f5786b, null);
    }

    public static boolean c() {
        au.a("canSave " + f5785a, null);
        return f5785a;
    }

    public static boolean d() {
        boolean z = f5786b < 3 && a() != c && f5785a;
        au.a("canSend " + z, null);
        return z;
    }

    public static void e() {
        c = a();
        au.a("setSendFinished " + c, null);
    }

    public static void a(boolean z) {
        f5785a = z;
    }
}
