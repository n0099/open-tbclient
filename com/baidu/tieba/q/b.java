package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class b {
    private static volatile a muk;

    public static synchronized a dAZ() {
        a aVar;
        synchronized (b.class) {
            if (muk == null) {
                muk = new a();
            }
            aVar = muk;
        }
        return aVar;
    }
}
