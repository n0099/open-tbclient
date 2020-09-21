package com.baidu.tieba.q;
/* loaded from: classes19.dex */
public class j {
    private static volatile i meM;

    public static synchronized i dxu() {
        i iVar;
        synchronized (j.class) {
            if (meM == null) {
                meM = new i();
            }
            iVar = meM;
        }
        return iVar;
    }
}
