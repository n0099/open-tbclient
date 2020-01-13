package com.baidu.tieba.p;
/* loaded from: classes5.dex */
public class d {
    private static volatile c jWq;

    public static synchronized c cGD() {
        c cVar;
        synchronized (d.class) {
            if (jWq == null) {
                jWq = new c();
            }
            cVar = jWq;
        }
        return cVar;
    }
}
