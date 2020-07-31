package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a mwX;

    public static synchronized a duU() {
        a aVar;
        synchronized (b.class) {
            if (mwX == null) {
                mwX = new a();
            }
            aVar = mwX;
        }
        return aVar;
    }
}
