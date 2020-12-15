package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class r {
    private static volatile q nbW;

    public static synchronized q dLY() {
        q qVar;
        synchronized (r.class) {
            if (nbW == null) {
                nbW = new q();
            }
            qVar = nbW;
        }
        return qVar;
    }
}
