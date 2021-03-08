package com.bytedance.embedapplog;

import com.bytedance.a.a;
/* loaded from: classes6.dex */
public final class bb {

    /* renamed from: a  reason: collision with root package name */
    private static int f3912a;
    private static com.bytedance.a.a ppu;

    static {
        a(2);
        a(new a.C0994a());
    }

    public static void a(com.bytedance.a.a aVar) {
        ppu = aVar;
    }

    public static void a(int i) {
        f3912a = i;
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (ppu != null && f3912a <= 2) {
            ppu.h(str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (ppu != null && f3912a <= 3) {
            ppu.j(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (ppu != null && f3912a <= 6) {
            ppu.k(str, str2, th);
        }
    }
}
