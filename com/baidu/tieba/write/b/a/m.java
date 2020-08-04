package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class m {
    private static volatile l mxj;

    public static synchronized l dvb() {
        l lVar;
        synchronized (m.class) {
            if (mxj == null) {
                mxj = new l();
            }
            lVar = mxj;
        }
        return lVar;
    }
}
