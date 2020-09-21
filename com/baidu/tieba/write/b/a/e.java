package com.baidu.tieba.write.b.a;
/* loaded from: classes19.dex */
public class e {
    private static volatile d mZH;

    public static synchronized d dKw() {
        d dVar;
        synchronized (e.class) {
            if (mZH == null) {
                mZH = new d();
            }
            dVar = mZH;
        }
        return dVar;
    }
}
