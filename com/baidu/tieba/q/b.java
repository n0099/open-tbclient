package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class b {
    private static volatile a lVf;

    public static synchronized a dtv() {
        a aVar;
        synchronized (b.class) {
            if (lVf == null) {
                lVf = new a();
            }
            aVar = lVf;
        }
        return aVar;
    }
}
