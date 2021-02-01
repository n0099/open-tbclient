package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class r {
    private static volatile q nmD;

    public static synchronized q dKi() {
        q qVar;
        synchronized (r.class) {
            if (nmD == null) {
                nmD = new q();
            }
            qVar = nmD;
        }
        return qVar;
    }
}
