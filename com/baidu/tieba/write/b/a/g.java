package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class g {
    private static volatile f mPN;

    public static synchronized f dGD() {
        f fVar;
        synchronized (g.class) {
            if (mPN == null) {
                mPN = new f();
            }
            fVar = mPN;
        }
        return fVar;
    }
}
