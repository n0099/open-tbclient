package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j mph;

    public static synchronized j drN() {
        j jVar;
        synchronized (k.class) {
            if (mph == null) {
                mph = new j();
            }
            jVar = mph;
        }
        return jVar;
    }
}
