package com.bytedance.embedapplog;

import com.bytedance.a.a;
/* loaded from: classes4.dex */
public final class bb {

    /* renamed from: a  reason: collision with root package name */
    private static int f5795a;
    private static com.bytedance.a.a pcw;

    static {
        a(2);
        a(new a.C0980a());
    }

    public static void a(com.bytedance.a.a aVar) {
        pcw = aVar;
    }

    public static void a(int i) {
        f5795a = i;
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (pcw != null && f5795a <= 2) {
            pcw.h(str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (pcw != null && f5795a <= 3) {
            pcw.j(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (pcw != null && f5795a <= 6) {
            pcw.k(str, str2, th);
        }
    }
}
