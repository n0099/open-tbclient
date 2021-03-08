package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class n {
    private static volatile m npi;

    public static synchronized m dKw() {
        m mVar;
        synchronized (n.class) {
            if (npi == null) {
                npi = new m();
            }
            mVar = npi;
        }
        return mVar;
    }
}
