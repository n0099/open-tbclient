package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j mpe;

    public static synchronized j drJ() {
        j jVar;
        synchronized (k.class) {
            if (mpe == null) {
                mpe = new j();
            }
            jVar = mpe;
        }
        return jVar;
    }
}
