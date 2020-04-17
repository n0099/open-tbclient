package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j lAh;

    public static synchronized j dfS() {
        j jVar;
        synchronized (k.class) {
            if (lAh == null) {
                lAh = new j();
            }
            jVar = lAh;
        }
        return jVar;
    }
}
