package com.bytedance.sdk.adnet.d;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f4053a;
    private b pxU;

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

    private c() {
        this.f4053a = a.OFF;
        this.pxU = new com.bytedance.sdk.adnet.d.a();
    }

    /* renamed from: com.bytedance.sdk.adnet.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C1009c {
        private static final c pxV = new c();
    }

    public static void a(a aVar) {
        synchronized (c.class) {
            C1009c.pxV.f4053a = aVar;
        }
    }

    public static void a(String str, String str2) {
        if (C1009c.pxV.f4053a.compareTo(a.ERROR) <= 0) {
            C1009c.pxV.pxU.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (C1009c.pxV.f4053a.compareTo(a.DEBUG) <= 0) {
            C1009c.pxV.pxU.b(str, str2);
        }
    }
}
