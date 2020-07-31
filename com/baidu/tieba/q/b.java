package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class b {
    private static volatile a lDk;

    public static synchronized a dhV() {
        a aVar;
        synchronized (b.class) {
            if (lDk == null) {
                lDk = new a();
            }
            aVar = lDk;
        }
        return aVar;
    }
}
