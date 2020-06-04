package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l lUL;

    public static synchronized l dny() {
        l lVar;
        synchronized (m.class) {
            if (lUL == null) {
                lUL = new l();
            }
            lVar = lUL;
        }
        return lVar;
    }
}
