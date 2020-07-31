package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class k {
    private static volatile j mxg;

    public static synchronized j duZ() {
        j jVar;
        synchronized (k.class) {
            if (mxg == null) {
                mxg = new j();
            }
            jVar = mxg;
        }
        return jVar;
    }
}
