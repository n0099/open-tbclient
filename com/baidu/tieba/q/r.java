package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class r {
    private static volatile q ncV;

    public static synchronized q dHX() {
        q qVar;
        synchronized (r.class) {
            if (ncV == null) {
                ncV = new q();
            }
            qVar = ncV;
        }
        return qVar;
    }
}
