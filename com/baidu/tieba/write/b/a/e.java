package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d nXj;

    public static synchronized d dZk() {
        d dVar;
        synchronized (e.class) {
            if (nXj == null) {
                nXj = new d();
            }
            dVar = nXj;
        }
        return dVar;
    }
}
