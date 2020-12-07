package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class j {
    private static volatile i nbR;

    public static synchronized i dLS() {
        i iVar;
        synchronized (j.class) {
            if (nbR == null) {
                nbR = new i();
            }
            iVar = nbR;
        }
        return iVar;
    }
}
