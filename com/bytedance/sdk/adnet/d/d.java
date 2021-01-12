package com.bytedance.sdk.adnet.d;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private a f6052a;
    private b pla;

    /* loaded from: classes4.dex */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    private d() {
        this.f6052a = a.OFF;
        this.pla = new com.bytedance.sdk.adnet.d.a();
    }

    /* loaded from: classes4.dex */
    private static class c {
        private static final d plb = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            c.plb.f6052a = aVar;
        }
    }

    public static void a(String str, String str2) {
        if (c.plb.f6052a.compareTo(a.ERROR) <= 0) {
            c.plb.pla.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (c.plb.f6052a.compareTo(a.DEBUG) <= 0) {
            c.plb.pla.b(str, str2);
        }
    }
}
