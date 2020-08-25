package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class g {
    private static volatile f mPv;

    public static synchronized f dGu() {
        f fVar;
        synchronized (g.class) {
            if (mPv == null) {
                mPv = new f();
            }
            fVar = mPv;
        }
        return fVar;
    }
}
