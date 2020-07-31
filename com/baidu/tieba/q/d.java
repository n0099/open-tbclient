package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class d {
    private static volatile c lDm;

    public static synchronized c dhW() {
        c cVar;
        synchronized (d.class) {
            if (lDm == null) {
                lDm = new c();
            }
            cVar = lDm;
        }
        return cVar;
    }
}
