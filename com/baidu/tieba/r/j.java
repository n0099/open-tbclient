package com.baidu.tieba.r;
/* loaded from: classes19.dex */
public class j {
    private static volatile i mNO;

    public static synchronized i dGG() {
        i iVar;
        synchronized (j.class) {
            if (mNO == null) {
                mNO = new i();
            }
            iVar = mNO;
        }
        return iVar;
    }
}
