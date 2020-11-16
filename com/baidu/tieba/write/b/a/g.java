package com.baidu.tieba.write.b.a;
/* loaded from: classes19.dex */
public class g {
    private static volatile f nJc;

    public static synchronized f dTQ() {
        f fVar;
        synchronized (g.class) {
            if (nJc == null) {
                nJc = new f();
            }
            fVar = nJc;
        }
        return fVar;
    }
}
