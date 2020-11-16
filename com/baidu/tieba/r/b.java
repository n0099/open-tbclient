package com.baidu.tieba.r;
/* loaded from: classes19.dex */
public class b {
    private static volatile a mNJ;

    public static synchronized a dGA() {
        a aVar;
        synchronized (b.class) {
            if (mNJ == null) {
                mNJ = new a();
            }
            aVar = mNJ;
        }
        return aVar;
    }
}
