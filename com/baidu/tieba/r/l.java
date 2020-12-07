package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class l {
    private static volatile k nbS;

    public static synchronized k dLT() {
        k kVar;
        synchronized (l.class) {
            if (nbS == null) {
                nbS = new k();
            }
            kVar = nbS;
        }
        return kVar;
    }
}
