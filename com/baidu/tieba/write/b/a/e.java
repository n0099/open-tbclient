package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d nHA;

    public static synchronized d dTQ() {
        d dVar;
        synchronized (e.class) {
            if (nHA == null) {
                nHA = new d();
            }
            dVar = nHA;
        }
        return dVar;
    }
}
