package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f lTx;

    public static synchronized f dne() {
        f fVar;
        synchronized (g.class) {
            if (lTx == null) {
                lTx = new f();
            }
            fVar = lTx;
        }
        return fVar;
    }
}
