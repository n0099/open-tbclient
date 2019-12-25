package com.baidu.tieba.p;
/* loaded from: classes4.dex */
public class d {
    private static volatile c jSO;

    public static synchronized c cFz() {
        c cVar;
        synchronized (d.class) {
            if (jSO == null) {
                jSO = new c();
            }
            cVar = jSO;
        }
        return cVar;
    }
}
