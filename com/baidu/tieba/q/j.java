package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i nna;

    public static synchronized i dKm() {
        i iVar;
        synchronized (j.class) {
            if (nna == null) {
                nna = new i();
            }
            iVar = nna;
        }
        return iVar;
    }
}
