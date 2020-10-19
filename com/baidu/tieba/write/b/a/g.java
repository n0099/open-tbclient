package com.baidu.tieba.write.b.a;
/* loaded from: classes20.dex */
public class g {
    private static volatile f npi;

    public static synchronized f dOj() {
        f fVar;
        synchronized (g.class) {
            if (npi == null) {
                npi = new f();
            }
            fVar = npi;
        }
        return fVar;
    }
}
