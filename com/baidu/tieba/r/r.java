package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class r {
    private static volatile q nbU;

    public static synchronized q dLX() {
        q qVar;
        synchronized (r.class) {
            if (nbU == null) {
                nbU = new q();
            }
            qVar = nbU;
        }
        return qVar;
    }
}
