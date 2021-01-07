package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class r {
    private static volatile q nhA;

    public static synchronized q dLP() {
        q qVar;
        synchronized (r.class) {
            if (nhA == null) {
                nhA = new q();
            }
            qVar = nhA;
        }
        return qVar;
    }
}
