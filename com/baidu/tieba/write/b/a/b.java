package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a mPo;

    public static synchronized a dGr() {
        a aVar;
        synchronized (b.class) {
            if (mPo == null) {
                mPo = new a();
            }
            aVar = mPo;
        }
        return aVar;
    }
}
