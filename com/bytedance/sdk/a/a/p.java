package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class p {

    /* renamed from: b  reason: collision with root package name */
    static long f5850b;
    static o pdo;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o emm() {
        synchronized (p.class) {
            if (pdo != null) {
                o oVar = pdo;
                pdo = oVar.pdA;
                oVar.pdA = null;
                f5850b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(o oVar) {
        if (oVar.pdA != null || oVar.pdB != null) {
            throw new IllegalArgumentException();
        }
        if (!oVar.d) {
            synchronized (p.class) {
                if (f5850b + 8192 <= 65536) {
                    f5850b += 8192;
                    oVar.pdA = pdo;
                    oVar.c = 0;
                    oVar.f5849b = 0;
                    pdo = oVar;
                }
            }
        }
    }
}
