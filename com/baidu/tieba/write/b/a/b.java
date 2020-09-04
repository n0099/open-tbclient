package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a mPG;

    public static synchronized a dGA() {
        a aVar;
        synchronized (b.class) {
            if (mPG == null) {
                mPG = new a();
            }
            aVar = mPG;
        }
        return aVar;
    }
}
