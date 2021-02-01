package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class n {
    private static volatile m nmC;

    public static synchronized m dKg() {
        m mVar;
        synchronized (n.class) {
            if (nmC == null) {
                nmC = new m();
            }
            mVar = nmC;
        }
        return mVar;
    }
}
