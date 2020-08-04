package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class b {
    private static volatile a lDm;

    public static synchronized a dhV() {
        a aVar;
        synchronized (b.class) {
            if (lDm == null) {
                lDm = new a();
            }
            aVar = lDm;
        }
        return aVar;
    }
}
