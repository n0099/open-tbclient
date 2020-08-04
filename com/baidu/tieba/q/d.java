package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class d {
    private static volatile c lDo;

    public static synchronized c dhW() {
        c cVar;
        synchronized (d.class) {
            if (lDo == null) {
                lDo = new c();
            }
            cVar = lDo;
        }
        return cVar;
    }
}
