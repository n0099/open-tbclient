package com.bytedance.sdk.adnet.d;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public a f27739a;

    /* renamed from: b  reason: collision with root package name */
    public c f27740b;

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
    public static class C0294d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f27746a = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            C0294d.f27746a.f27739a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0294d.f27746a.f27739a.compareTo(a.ERROR) <= 0) {
            C0294d.f27746a.f27740b.a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (C0294d.f27746a.f27739a.compareTo(a.DEBUG) <= 0) {
            C0294d.f27746a.f27740b.b(str, str2);
        }
    }

    public d() {
        this.f27739a = a.OFF;
        this.f27740b = new d.b.c.b.e.b();
    }
}
