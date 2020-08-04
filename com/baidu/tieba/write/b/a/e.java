package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class e {
    private static volatile d mxf;

    public static synchronized d duX() {
        d dVar;
        synchronized (e.class) {
            if (mxf == null) {
                mxf = new d();
            }
            dVar = mxf;
        }
        return dVar;
    }
}
