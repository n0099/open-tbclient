package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h lUJ;

    public static synchronized h dnw() {
        h hVar;
        synchronized (i.class) {
            if (lUJ == null) {
                lUJ = new h();
            }
            hVar = lUJ;
        }
        return hVar;
    }
}
