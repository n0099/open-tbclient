package com.bytedance.sdk.adnet.d;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public a f26915a;

    /* renamed from: b  reason: collision with root package name */
    public c f26916b;

    /* loaded from: classes5.dex */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.adnet.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0299d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f26922a = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            C0299d.f26922a.f26915a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0299d.f26922a.f26915a.compareTo(a.ERROR) <= 0) {
            C0299d.f26922a.f26916b.a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (C0299d.f26922a.f26915a.compareTo(a.DEBUG) <= 0) {
            C0299d.f26922a.f26916b.b(str, str2);
        }
    }

    public d() {
        this.f26915a = a.OFF;
        this.f26916b = new d.c.c.b.e.b();
    }
}
