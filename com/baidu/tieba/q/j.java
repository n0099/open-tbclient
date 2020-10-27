package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class j {
    private static volatile i mGV;

    public static synchronized i dEn() {
        i iVar;
        synchronized (j.class) {
            if (mGV == null) {
                mGV = new i();
            }
            iVar = mGV;
        }
        return iVar;
    }
}
