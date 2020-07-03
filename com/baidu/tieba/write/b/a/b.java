package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a moV;

    public static synchronized a drE() {
        a aVar;
        synchronized (b.class) {
            if (moV == null) {
                moV = new a();
            }
            aVar = moV;
        }
        return aVar;
    }
}
