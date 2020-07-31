package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class i {
    private static volatile h mxf;

    public static synchronized h duY() {
        h hVar;
        synchronized (i.class) {
            if (mxf == null) {
                mxf = new h();
            }
            hVar = mxf;
        }
        return hVar;
    }
}
