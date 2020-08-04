package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class j {
    private static volatile i lDr;

    public static synchronized i dib() {
        i iVar;
        synchronized (j.class) {
            if (lDr == null) {
                lDr = new i();
            }
            iVar = lDr;
        }
        return iVar;
    }
}
