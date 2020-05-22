package com.baidu.ubc;
/* loaded from: classes7.dex */
public class i {
    private static volatile h mha;

    public static synchronized h drQ() {
        h hVar;
        synchronized (i.class) {
            if (mha == null) {
                mha = new h();
            }
            hVar = mha;
        }
        return hVar;
    }
}
