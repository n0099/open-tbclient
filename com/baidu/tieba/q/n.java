package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class n {
    private static volatile m nhz;

    public static synchronized m dLN() {
        m mVar;
        synchronized (n.class) {
            if (nhz == null) {
                nhz = new m();
            }
            mVar = nhz;
        }
        return mVar;
    }
}
