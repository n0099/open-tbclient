package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class g {
    private static volatile f nXk;

    public static synchronized f dZl() {
        f fVar;
        synchronized (g.class) {
            if (nXk == null) {
                nXk = new f();
            }
            fVar = nXk;
        }
        return fVar;
    }
}
