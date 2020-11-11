package com.baidu.tieba.q;
/* loaded from: classes20.dex */
public class j {
    private static volatile i mMV;

    public static synchronized i dGP() {
        i iVar;
        synchronized (j.class) {
            if (mMV == null) {
                mMV = new i();
            }
            iVar = mMV;
        }
        return iVar;
    }
}
