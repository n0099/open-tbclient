package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class k {
    private static volatile j mPP;

    public static synchronized j dGF() {
        j jVar;
        synchronized (k.class) {
            if (mPP == null) {
                mPP = new j();
            }
            jVar = mPP;
        }
        return jVar;
    }
}
