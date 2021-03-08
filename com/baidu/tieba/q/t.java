package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class t {
    private static volatile s npk;

    public static synchronized s dKA() {
        s sVar;
        synchronized (t.class) {
            if (npk == null) {
                npk = new s();
            }
            sVar = npk;
        }
        return sVar;
    }
}
