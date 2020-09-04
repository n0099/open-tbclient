package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class i {
    private static volatile h mPO;

    public static synchronized h dGE() {
        h hVar;
        synchronized (i.class) {
            if (mPO == null) {
                mPO = new h();
            }
            hVar = mPO;
        }
        return hVar;
    }
}
