package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d nph;

    public static synchronized d dOi() {
        d dVar;
        synchronized (e.class) {
            if (nph == null) {
                nph = new d();
            }
            dVar = nph;
        }
        return dVar;
    }
}
