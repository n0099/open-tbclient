package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class d {
    private static volatile c lVh;

    public static synchronized c dtw() {
        c cVar;
        synchronized (d.class) {
            if (lVh == null) {
                lVh = new c();
            }
            cVar = lVh;
        }
        return cVar;
    }
}
