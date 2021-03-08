package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class p {
    static long b;
    static o pqm;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o eoV() {
        synchronized (p.class) {
            if (pqm != null) {
                o oVar = pqm;
                pqm = oVar.pqy;
                oVar.pqy = null;
                b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(o oVar) {
        if (oVar.pqy != null || oVar.pqz != null) {
            throw new IllegalArgumentException();
        }
        if (!oVar.d) {
            synchronized (p.class) {
                if (b + 8192 <= 65536) {
                    b += 8192;
                    oVar.pqy = pqm;
                    oVar.c = 0;
                    oVar.b = 0;
                    pqm = oVar;
                }
            }
        }
    }
}
