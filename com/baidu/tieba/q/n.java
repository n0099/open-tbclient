package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class n {
    private static volatile m nnc;

    public static synchronized m dKo() {
        m mVar;
        synchronized (n.class) {
            if (nnc == null) {
                nnc = new m();
            }
            mVar = nnc;
        }
        return mVar;
    }
}
