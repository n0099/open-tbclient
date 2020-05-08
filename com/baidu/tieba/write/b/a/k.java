package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j lAl;

    public static synchronized j dfP() {
        j jVar;
        synchronized (k.class) {
            if (lAl == null) {
                lAl = new j();
            }
            jVar = lAl;
        }
        return jVar;
    }
}
