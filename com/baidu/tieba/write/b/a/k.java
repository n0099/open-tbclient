package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j lTz;

    public static synchronized j dng() {
        j jVar;
        synchronized (k.class) {
            if (lTz == null) {
                lTz = new j();
            }
            jVar = lTz;
        }
        return jVar;
    }
}
