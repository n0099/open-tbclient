package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class r {
    private static volatile q nhB;

    public static synchronized q dLO() {
        q qVar;
        synchronized (r.class) {
            if (nhB == null) {
                nhB = new q();
            }
            qVar = nhB;
        }
        return qVar;
    }
}
