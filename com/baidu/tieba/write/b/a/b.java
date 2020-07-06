package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a moY;

    public static synchronized a drI() {
        a aVar;
        synchronized (b.class) {
            if (moY == null) {
                moY = new a();
            }
            aVar = moY;
        }
        return aVar;
    }
}
