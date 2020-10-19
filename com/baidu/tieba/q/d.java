package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class d {
    private static volatile c mum;

    public static synchronized c dBa() {
        c cVar;
        synchronized (d.class) {
            if (mum == null) {
                mum = new c();
            }
            cVar = mum;
        }
        return cVar;
    }
}
