package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class m {
    private static volatile l mPy;

    public static synchronized l dGx() {
        l lVar;
        synchronized (m.class) {
            if (mPy == null) {
                mPy = new l();
            }
            lVar = mPy;
        }
        return lVar;
    }
}
