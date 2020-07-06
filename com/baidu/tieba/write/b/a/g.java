package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class g {
    private static volatile f mpf;

    public static synchronized f drL() {
        f fVar;
        synchronized (g.class) {
            if (mpf == null) {
                mpf = new f();
            }
            fVar = mpf;
        }
        return fVar;
    }
}
