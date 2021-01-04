package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class p {

    /* renamed from: b  reason: collision with root package name */
    static long f6149b;
    static o phQ;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o eqh() {
        synchronized (p.class) {
            if (phQ != null) {
                o oVar = phQ;
                phQ = oVar.pie;
                oVar.pie = null;
                f6149b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(o oVar) {
        if (oVar.pie != null || oVar.pif != null) {
            throw new IllegalArgumentException();
        }
        if (!oVar.d) {
            synchronized (p.class) {
                if (f6149b + 8192 <= 65536) {
                    f6149b += 8192;
                    oVar.pie = phQ;
                    oVar.c = 0;
                    oVar.f6148b = 0;
                    phQ = oVar;
                }
            }
        }
    }
}
