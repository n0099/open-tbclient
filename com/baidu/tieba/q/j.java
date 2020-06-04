package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class j {
    private static volatile i lcb;

    public static synchronized i daB() {
        i iVar;
        synchronized (j.class) {
            if (lcb == null) {
                lcb = new i();
            }
            iVar = lcb;
        }
        return iVar;
    }
}
