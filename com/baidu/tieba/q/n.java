package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class n {
    private static volatile m ncU;

    public static synchronized m dHV() {
        m mVar;
        synchronized (n.class) {
            if (ncU == null) {
                ncU = new m();
            }
            mVar = ncU;
        }
        return mVar;
    }
}
