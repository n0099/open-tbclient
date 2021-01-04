package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class t {
    private static volatile s nhC;

    public static synchronized s dLQ() {
        s sVar;
        synchronized (t.class) {
            if (nhC == null) {
                nhC = new s();
            }
            sVar = nhC;
        }
        return sVar;
    }
}
