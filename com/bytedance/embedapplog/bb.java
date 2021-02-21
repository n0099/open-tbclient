package com.bytedance.embedapplog;

import com.bytedance.a.a;
/* loaded from: classes6.dex */
public final class bb {

    /* renamed from: a  reason: collision with root package name */
    private static int f5797a;
    private static com.bytedance.a.a pnk;

    static {
        a(2);
        a(new a.C0986a());
    }

    public static void a(com.bytedance.a.a aVar) {
        pnk = aVar;
    }

    public static void a(int i) {
        f5797a = i;
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (pnk != null && f5797a <= 2) {
            pnk.h(str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (pnk != null && f5797a <= 3) {
            pnk.j(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (pnk != null && f5797a <= 6) {
            pnk.k(str, str2, th);
        }
    }
}
