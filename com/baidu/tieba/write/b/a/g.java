package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class g {
    private static volatile f nHB;

    public static synchronized f dTR() {
        f fVar;
        synchronized (g.class) {
            if (nHB == null) {
                nHB = new f();
            }
            fVar = nHB;
        }
        return fVar;
    }
}
