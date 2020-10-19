package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class j {
    private static volatile i mup;

    public static synchronized i dBf() {
        i iVar;
        synchronized (j.class) {
            if (mup == null) {
                mup = new i();
            }
            iVar = mup;
        }
        return iVar;
    }
}
