package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class l {
    private static volatile k nmB;

    public static synchronized k dKf() {
        k kVar;
        synchronized (l.class) {
            if (nmB == null) {
                nmB = new k();
            }
            kVar = nmB;
        }
        return kVar;
    }
}
