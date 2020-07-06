package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h mpg;

    public static synchronized h drM() {
        h hVar;
        synchronized (i.class) {
            if (mpg == null) {
                mpg = new h();
            }
            hVar = mpg;
        }
        return hVar;
    }
}
