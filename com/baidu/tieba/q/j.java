package com.baidu.tieba.q;
/* loaded from: classes6.dex */
public class j {
    private static volatile i ncS;

    public static synchronized i dHT() {
        i iVar;
        synchronized (j.class) {
            if (ncS == null) {
                ncS = new i();
            }
            iVar = ncS;
        }
        return iVar;
    }
}
