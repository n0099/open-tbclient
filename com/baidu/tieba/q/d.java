package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class d {
    private static volatile c mMS;

    public static synchronized c dGK() {
        c cVar;
        synchronized (d.class) {
            if (mMS == null) {
                mMS = new c();
            }
            cVar = mMS;
        }
        return cVar;
    }
}
