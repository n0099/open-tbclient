package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class l {
    private static volatile k nbU;

    public static synchronized k dLU() {
        k kVar;
        synchronized (l.class) {
            if (nbU == null) {
                nbU = new k();
            }
            kVar = nbU;
        }
        return kVar;
    }
}
