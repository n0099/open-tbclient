package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class r {
    private static volatile q npj;

    public static synchronized q dKy() {
        q qVar;
        synchronized (r.class) {
            if (npj == null) {
                npj = new q();
            }
            qVar = npj;
        }
        return qVar;
    }
}
