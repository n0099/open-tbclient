package com.baidu.tieba.q;
/* loaded from: classes19.dex */
public class b {
    private static volatile a meH;

    public static synchronized a dxo() {
        a aVar;
        synchronized (b.class) {
            if (meH == null) {
                meH = new a();
            }
            aVar = meH;
        }
        return aVar;
    }
}
