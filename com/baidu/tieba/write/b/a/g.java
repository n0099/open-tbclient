package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f lAj;

    public static synchronized f dfO() {
        f fVar;
        synchronized (g.class) {
            if (lAj == null) {
                lAj = new f();
            }
            fVar = lAj;
        }
        return fVar;
    }
}
