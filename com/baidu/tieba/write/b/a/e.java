package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d nBG;

    public static synchronized d dRq() {
        d dVar;
        synchronized (e.class) {
            if (nBG == null) {
                nBG = new d();
            }
            dVar = nBG;
        }
        return dVar;
    }
}
