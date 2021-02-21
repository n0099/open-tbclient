package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class r {
    private static volatile q nnd;

    public static synchronized q dKq() {
        q qVar;
        synchronized (r.class) {
            if (nnd == null) {
                nnd = new q();
            }
            qVar = nnd;
        }
        return qVar;
    }
}
