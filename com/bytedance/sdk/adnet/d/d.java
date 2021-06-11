package com.bytedance.sdk.adnet.d;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public a f27016a;

    /* renamed from: b  reason: collision with root package name */
    public c f27017b;

    /* loaded from: classes6.dex */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.adnet.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0284d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f27023a = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            C0284d.f27023a.f27016a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0284d.f27023a.f27016a.compareTo(a.ERROR) <= 0) {
            C0284d.f27023a.f27017b.a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (C0284d.f27023a.f27016a.compareTo(a.DEBUG) <= 0) {
            C0284d.f27023a.f27017b.b(str, str2);
        }
    }

    public d() {
        this.f27016a = a.OFF;
        this.f27017b = new d.b.c.b.e.b();
    }
}
