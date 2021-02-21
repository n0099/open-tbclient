package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: b  reason: collision with root package name */
    static long f5852b;
    static o poc;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o eoO() {
        synchronized (p.class) {
            if (poc != null) {
                o oVar = poc;
                poc = oVar.poq;
                oVar.poq = null;
                f5852b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(o oVar) {
        if (oVar.poq != null || oVar.por != null) {
            throw new IllegalArgumentException();
        }
        if (!oVar.d) {
            synchronized (p.class) {
                if (f5852b + 8192 <= 65536) {
                    f5852b += 8192;
                    oVar.poq = poc;
                    oVar.c = 0;
                    oVar.f5851b = 0;
                    poc = oVar;
                }
            }
        }
    }
}
