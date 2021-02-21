package com.bytedance.sdk.adnet.d;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private a f6054a;
    private b pvQ;

    /* loaded from: classes6.dex */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    private d() {
        this.f6054a = a.OFF;
        this.pvQ = new com.bytedance.sdk.adnet.d.a();
    }

    /* loaded from: classes6.dex */
    private static class c {
        private static final d pvR = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            c.pvR.f6054a = aVar;
        }
    }

    public static void a(String str, String str2) {
        if (c.pvR.f6054a.compareTo(a.ERROR) <= 0) {
            c.pvR.pvQ.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (c.pvR.f6054a.compareTo(a.DEBUG) <= 0) {
            c.pvR.pvQ.b(str, str2);
        }
    }
}
