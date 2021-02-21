package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class l {
    private static volatile k nnb;

    public static synchronized k dKn() {
        k kVar;
        synchronized (l.class) {
            if (nnb == null) {
                nnb = new k();
            }
            kVar = nnb;
        }
        return kVar;
    }
}
