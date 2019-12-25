package com.baidu.tieba.p;
/* loaded from: classes4.dex */
public class b {
    private static volatile a jSN;

    public static synchronized a cFy() {
        a aVar;
        synchronized (b.class) {
            if (jSN == null) {
                jSN = new a();
            }
            aVar = jSN;
        }
        return aVar;
    }
}
