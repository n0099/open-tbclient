package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class k {
    private static volatile j mxi;

    public static synchronized j dva() {
        j jVar;
        synchronized (k.class) {
            if (mxi == null) {
                mxi = new j();
            }
            jVar = mxi;
        }
        return jVar;
    }
}
