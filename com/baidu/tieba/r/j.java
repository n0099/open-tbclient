package com.baidu.tieba.r;
/* loaded from: classes20.dex */
public class j {
    private static volatile i nbT;

    public static synchronized i dLT() {
        i iVar;
        synchronized (j.class) {
            if (nbT == null) {
                nbT = new i();
            }
            iVar = nbT;
        }
        return iVar;
    }
}
