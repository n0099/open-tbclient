package com.bytedance.sdk.adnet.d;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private a f6351a;
    private b ppG;

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
        this.f6351a = a.OFF;
        this.ppG = new com.bytedance.sdk.adnet.d.a();
    }

    /* loaded from: classes4.dex */
    private static class c {
        private static final d ppH = new d();
    }

    public static void a(a aVar) {
        synchronized (d.class) {
            c.ppH.f6351a = aVar;
        }
    }

    public static void a(String str, String str2) {
        if (c.ppH.f6351a.compareTo(a.ERROR) <= 0) {
            c.ppH.ppG.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (c.ppH.f6351a.compareTo(a.DEBUG) <= 0) {
            c.ppH.ppG.b(str, str2);
        }
    }
}
