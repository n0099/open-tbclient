package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class e {
    private static volatile d mPM;

    public static synchronized d dGC() {
        d dVar;
        synchronized (e.class) {
            if (mPM == null) {
                mPM = new d();
            }
            dVar = mPM;
        }
        return dVar;
    }
}
