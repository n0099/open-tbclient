package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class m {
    private static volatile l mpi;

    public static synchronized l drO() {
        l lVar;
        synchronized (m.class) {
            if (mpi == null) {
                mpi = new l();
            }
            lVar = mpi;
        }
        return lVar;
    }
}
