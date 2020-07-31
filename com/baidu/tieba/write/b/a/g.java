package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class g {
    private static volatile f mxe;

    public static synchronized f duX() {
        f fVar;
        synchronized (g.class) {
            if (mxe == null) {
                mxe = new f();
            }
            fVar = mxe;
        }
        return fVar;
    }
}
