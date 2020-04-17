package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a lzX;

    public static synchronized a dfN() {
        a aVar;
        synchronized (b.class) {
            if (lzX == null) {
                lzX = new a();
            }
            aVar = lzX;
        }
        return aVar;
    }
}
