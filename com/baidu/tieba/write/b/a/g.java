package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class g {
    private static volatile f nXi;

    public static synchronized f dZk() {
        f fVar;
        synchronized (g.class) {
            if (nXi == null) {
                nXi = new f();
            }
            fVar = nXi;
        }
        return fVar;
    }
}
