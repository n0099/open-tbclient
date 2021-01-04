package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c nht;

    public static synchronized c dLH() {
        c cVar;
        synchronized (d.class) {
            if (nht == null) {
                nht = new c();
            }
            cVar = nht;
        }
        return cVar;
    }
}
