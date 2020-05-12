package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i kIC;

    public static synchronized i cTh() {
        i iVar;
        synchronized (j.class) {
            if (kIC == null) {
                kIC = new i();
            }
            iVar = kIC;
        }
        return iVar;
    }
}
