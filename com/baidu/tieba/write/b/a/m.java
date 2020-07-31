package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class m {
    private static volatile l mxh;

    public static synchronized l dva() {
        l lVar;
        synchronized (m.class) {
            if (mxh == null) {
                mxh = new l();
            }
            lVar = mxh;
        }
        return lVar;
    }
}
