package com.baidu.tieba.r;
/* loaded from: classes19.dex */
public class d {
    private static volatile c mNL;

    public static synchronized c dGB() {
        c cVar;
        synchronized (d.class) {
            if (mNL == null) {
                mNL = new c();
            }
            cVar = mNL;
        }
        return cVar;
    }
}
