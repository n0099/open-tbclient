package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class l {
    private static volatile k nhy;

    public static synchronized k dLM() {
        k kVar;
        synchronized (l.class) {
            if (nhy == null) {
                nhy = new k();
            }
            kVar = nhy;
        }
        return kVar;
    }
}
