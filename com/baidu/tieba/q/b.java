package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class b {
    private static volatile a mGQ;

    public static synchronized a dEh() {
        a aVar;
        synchronized (b.class) {
            if (mGQ == null) {
                mGQ = new a();
            }
            aVar = mGQ;
        }
        return aVar;
    }
}
