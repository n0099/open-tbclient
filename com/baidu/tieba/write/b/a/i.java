package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class i {
    private static volatile h mxh;

    public static synchronized h duZ() {
        h hVar;
        synchronized (i.class) {
            if (mxh == null) {
                mxh = new h();
            }
            hVar = mxh;
        }
        return hVar;
    }
}
