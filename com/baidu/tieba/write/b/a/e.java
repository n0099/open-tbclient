package com.baidu.tieba.write.b.a;
/* loaded from: classes19.dex */
public class e {
    private static volatile d nJb;

    public static synchronized d dTP() {
        d dVar;
        synchronized (e.class) {
            if (nJb == null) {
                nJb = new d();
            }
            dVar = nJb;
        }
        return dVar;
    }
}
