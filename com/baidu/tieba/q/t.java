package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class t {
    private static volatile s ncW;

    public static synchronized s dHZ() {
        s sVar;
        synchronized (t.class) {
            if (ncW == null) {
                ncW = new s();
            }
            sVar = ncW;
        }
        return sVar;
    }
}
