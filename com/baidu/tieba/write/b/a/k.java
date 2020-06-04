package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class k {
    private static volatile j lUK;

    public static synchronized j dnx() {
        j jVar;
        synchronized (k.class) {
            if (lUK == null) {
                lUK = new j();
            }
            jVar = lUK;
        }
        return jVar;
    }
}
