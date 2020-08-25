package com.baidu.tieba.write.b.a;
/* loaded from: classes14.dex */
public class i {
    private static volatile h mPw;

    public static synchronized h dGv() {
        h hVar;
        synchronized (i.class) {
            if (mPw == null) {
                mPw = new h();
            }
            hVar = mPw;
        }
        return hVar;
    }
}
