package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a mwZ;

    public static synchronized a duV() {
        a aVar;
        synchronized (b.class) {
            if (mwZ == null) {
                mwZ = new a();
            }
            aVar = mwZ;
        }
        return aVar;
    }
}
