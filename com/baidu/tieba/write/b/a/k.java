package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class k {
    private static volatile j mPx;

    public static synchronized j dGw() {
        j jVar;
        synchronized (k.class) {
            if (mPx == null) {
                mPx = new j();
            }
            jVar = mPx;
        }
        return jVar;
    }
}
