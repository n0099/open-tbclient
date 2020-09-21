package com.baidu.tieba.write.b.a;
/* loaded from: classes19.dex */
public class g {
    private static volatile f mZI;

    public static synchronized f dKx() {
        f fVar;
        synchronized (g.class) {
            if (mZI == null) {
                mZI = new f();
            }
            fVar = mZI;
        }
        return fVar;
    }
}
