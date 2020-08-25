package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class b {
    private static volatile a lUQ;

    public static synchronized a dtq() {
        a aVar;
        synchronized (b.class) {
            if (lUQ == null) {
                lUQ = new a();
            }
            aVar = lUQ;
        }
        return aVar;
    }
}
