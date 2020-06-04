package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class b {
    private static volatile a lbW;

    public static synchronized a dav() {
        a aVar;
        synchronized (b.class) {
            if (lbW == null) {
                lbW = new a();
            }
            aVar = lbW;
        }
        return aVar;
    }
}
