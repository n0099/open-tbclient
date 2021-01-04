package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class l {
    private static volatile k nhz;

    public static synchronized k dLL() {
        k kVar;
        synchronized (l.class) {
            if (nhz == null) {
                nhz = new k();
            }
            kVar = nhz;
        }
        return kVar;
    }
}
