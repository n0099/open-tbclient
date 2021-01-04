package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i nhy;

    public static synchronized i dLK() {
        i iVar;
        synchronized (j.class) {
            if (nhy == null) {
                nhy = new i();
            }
            iVar = nhy;
        }
        return iVar;
    }
}
