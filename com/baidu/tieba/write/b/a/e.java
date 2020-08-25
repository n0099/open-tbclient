package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class e {
    private static volatile d mPu;

    public static synchronized d dGt() {
        d dVar;
        synchronized (e.class) {
            if (mPu == null) {
                mPu = new d();
            }
            dVar = mPu;
        }
        return dVar;
    }
}
