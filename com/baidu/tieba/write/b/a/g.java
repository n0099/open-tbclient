package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f mpc;

    public static synchronized f drH() {
        f fVar;
        synchronized (g.class) {
            if (mpc == null) {
                mpc = new f();
            }
            fVar = mpc;
        }
        return fVar;
    }
}
