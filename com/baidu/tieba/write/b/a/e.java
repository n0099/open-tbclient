package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class e {
    private static volatile d mxd;

    public static synchronized d duW() {
        d dVar;
        synchronized (e.class) {
            if (mxd == null) {
                mxd = new d();
            }
            dVar = mxd;
        }
        return dVar;
    }
}
