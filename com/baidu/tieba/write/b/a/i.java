package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class i {
    private static volatile h mpd;

    public static synchronized h drI() {
        h hVar;
        synchronized (i.class) {
            if (mpd == null) {
                mpd = new h();
            }
            hVar = mpd;
        }
        return hVar;
    }
}
