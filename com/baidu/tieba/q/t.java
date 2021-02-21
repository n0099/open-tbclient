package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class t {
    private static volatile s nne;

    public static synchronized s dKs() {
        s sVar;
        synchronized (t.class) {
            if (nne == null) {
                nne = new s();
            }
            sVar = nne;
        }
        return sVar;
    }
}
