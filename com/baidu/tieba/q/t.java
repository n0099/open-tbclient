package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class t {
    private static volatile s nhB;

    public static synchronized s dLR() {
        s sVar;
        synchronized (t.class) {
            if (nhB == null) {
                nhB = new s();
            }
            sVar = nhB;
        }
        return sVar;
    }
}
