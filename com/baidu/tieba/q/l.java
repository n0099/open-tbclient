package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class l {
    private static volatile k ncT;

    public static synchronized k dHU() {
        k kVar;
        synchronized (l.class) {
            if (ncT == null) {
                ncT = new k();
            }
            kVar = ncT;
        }
        return kVar;
    }
}
