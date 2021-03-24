package com.bytedance.sdk.adnet.d;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public a f27229a;

    /* renamed from: b  reason: collision with root package name */
    public c f27230b;

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
    public static class C0296d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f27236a = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            C0296d.f27236a.f27229a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0296d.f27236a.f27229a.compareTo(a.ERROR) <= 0) {
            C0296d.f27236a.f27230b.a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (C0296d.f27236a.f27229a.compareTo(a.DEBUG) <= 0) {
            C0296d.f27236a.f27230b.b(str, str2);
        }
    }

    public d() {
        this.f27229a = a.OFF;
        this.f27230b = new d.c.c.b.e.b();
    }
}
