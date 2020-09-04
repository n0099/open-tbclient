package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class m {
    private static volatile l mPQ;

    public static synchronized l dGG() {
        l lVar;
        synchronized (m.class) {
            if (mPQ == null) {
                mPQ = new l();
            }
            lVar = mPQ;
        }
        return lVar;
    }
}
