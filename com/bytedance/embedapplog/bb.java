package com.bytedance.embedapplog;

import com.bytedance.a.a;
/* loaded from: classes4.dex */
public final class bb {

    /* renamed from: a  reason: collision with root package name */
    private static int f6094a;
    private static com.bytedance.a.a pgX;

    static {
        a(2);
        a(new a.C0959a());
    }

    public static void a(com.bytedance.a.a aVar) {
        pgX = aVar;
    }

    public static void a(int i) {
        f6094a = i;
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (pgX != null && f6094a <= 2) {
            pgX.h(str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (pgX != null && f6094a <= 3) {
            pgX.j(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (pgX != null && f6094a <= 6) {
            pgX.k(str, str2, th);
        }
    }
}
