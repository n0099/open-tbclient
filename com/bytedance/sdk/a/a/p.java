package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: b  reason: collision with root package name */
    static long f5852b;
    static o pnC;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o eoG() {
        synchronized (p.class) {
            if (pnC != null) {
                o oVar = pnC;
                pnC = oVar.pnO;
                oVar.pnO = null;
                f5852b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(o oVar) {
        if (oVar.pnO != null || oVar.pnP != null) {
            throw new IllegalArgumentException();
        }
        if (!oVar.d) {
            synchronized (p.class) {
                if (f5852b + 8192 <= 65536) {
                    f5852b += 8192;
                    oVar.pnO = pnC;
                    oVar.c = 0;
                    oVar.f5851b = 0;
                    pnC = oVar;
                }
            }
        }
    }
}
