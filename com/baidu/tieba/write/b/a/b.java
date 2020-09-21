package com.baidu.tieba.write.b.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a mZB;

    public static synchronized a dKu() {
        a aVar;
        synchronized (b.class) {
            if (mZB == null) {
                mZB = new a();
            }
            aVar = mZB;
        }
        return aVar;
    }
}
