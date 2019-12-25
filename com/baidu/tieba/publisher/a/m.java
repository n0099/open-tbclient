package com.baidu.tieba.publisher.a;
/* loaded from: classes4.dex */
public class m {
    private static volatile l jxk;

    public static synchronized l cyu() {
        l lVar;
        synchronized (m.class) {
            if (jxk == null) {
                jxk = new l();
            }
            lVar = jxk;
        }
        return lVar;
    }
}
