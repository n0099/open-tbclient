package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d lAi;

    public static synchronized d dfN() {
        d dVar;
        synchronized (e.class) {
            if (lAi == null) {
                lAi = new d();
            }
            dVar = lAi;
        }
        return dVar;
    }
}
