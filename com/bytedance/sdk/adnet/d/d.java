package com.bytedance.sdk.adnet.d;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public a f27230a;

    /* renamed from: b  reason: collision with root package name */
    public c f27231b;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.adnet.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0297d {

        /* renamed from: a  reason: collision with root package name */
        public static final d f27237a = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            C0297d.f27237a.f27230a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0297d.f27237a.f27230a.compareTo(a.ERROR) <= 0) {
            C0297d.f27237a.f27231b.a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (C0297d.f27237a.f27230a.compareTo(a.DEBUG) <= 0) {
            C0297d.f27237a.f27231b.b(str, str2);
        }
    }

    public d() {
        this.f27230a = a.OFF;
        this.f27231b = new d.c.c.b.e.b();
    }
}
