package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l lTA;

    public static synchronized l dnh() {
        l lVar;
        synchronized (m.class) {
            if (lTA == null) {
                lTA = new l();
            }
            lVar = lTA;
        }
        return lVar;
    }
}
