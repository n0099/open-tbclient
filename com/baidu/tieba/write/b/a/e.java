package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d lAe;

    public static synchronized d dfP() {
        d dVar;
        synchronized (e.class) {
            if (lAe == null) {
                lAe = new d();
            }
            dVar = lAe;
        }
        return dVar;
    }
}
