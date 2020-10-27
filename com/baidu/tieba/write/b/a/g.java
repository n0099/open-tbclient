package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class g {
    private static volatile f nBH;

    public static synchronized f dRr() {
        f fVar;
        synchronized (g.class) {
            if (nBH == null) {
                nBH = new f();
            }
            fVar = nBH;
        }
        return fVar;
    }
}
