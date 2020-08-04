package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class g {
    private static volatile f mxg;

    public static synchronized f duY() {
        f fVar;
        synchronized (g.class) {
            if (mxg == null) {
                mxg = new f();
            }
            fVar = mxg;
        }
        return fVar;
    }
}
