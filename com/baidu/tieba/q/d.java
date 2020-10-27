package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class d {
    private static volatile c mGS;

    public static synchronized c dEi() {
        c cVar;
        synchronized (d.class) {
            if (mGS == null) {
                mGS = new c();
            }
            cVar = mGS;
        }
        return cVar;
    }
}
