package com.bytedance.sdk.openadsdk.api.b;
/* loaded from: classes3.dex */
public class d {
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f53396b = 4;

    public static void a(int i2) {
        f53396b = i2;
    }

    public static void b(String str, String str2) {
        if (a && str2 != null) {
            int i2 = f53396b;
        }
    }

    public static void c(String str, String str2) {
        if (a && str2 != null) {
            int i2 = f53396b;
        }
    }

    public static void d(String str, String str2) {
        if (a && str2 != null) {
            int i2 = f53396b;
        }
    }

    public static void a() {
        a = true;
        a(3);
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = f53396b;
        }
    }

    public static void a(String str, String str2) {
        if (a && str2 != null) {
            int i2 = f53396b;
        }
    }

    public static void a(String str) {
        if (a) {
            c("TTLogger", str);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = f53396b;
        }
    }
}
