package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class j {
    private static volatile i lDp;

    public static synchronized i dib() {
        i iVar;
        synchronized (j.class) {
            if (lDp == null) {
                lDp = new i();
            }
            iVar = lDp;
        }
        return iVar;
    }
}
