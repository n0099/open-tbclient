package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class t {
    private static volatile s nmE;

    public static synchronized s dKk() {
        s sVar;
        synchronized (t.class) {
            if (nmE == null) {
                nmE = new s();
            }
            sVar = nmE;
        }
        return sVar;
    }
}
