package com.baidu.tieba.p;
/* loaded from: classes5.dex */
public class d {
    private static volatile c jWv;

    public static synchronized c cGF() {
        c cVar;
        synchronized (d.class) {
            if (jWv == null) {
                jWv = new c();
            }
            cVar = jWv;
        }
        return cVar;
    }
}
