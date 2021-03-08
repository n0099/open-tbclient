package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class l {
    private static volatile k nph;

    public static synchronized k dKv() {
        k kVar;
        synchronized (l.class) {
            if (nph == null) {
                nph = new k();
            }
            kVar = nph;
        }
        return kVar;
    }
}
