package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class n {
    private static volatile m nhA;

    public static synchronized m dLM() {
        m mVar;
        synchronized (n.class) {
            if (nhA == null) {
                nhA = new m();
            }
            mVar = nhA;
        }
        return mVar;
    }
}
