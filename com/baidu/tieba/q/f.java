package com.baidu.tieba.q;
/* loaded from: classes7.dex */
public class f {
    private static volatile e lvW;

    public static synchronized e deO() {
        e eVar;
        synchronized (f.class) {
            if (lvW == null) {
                lvW = new e();
            }
            eVar = lvW;
        }
        return eVar;
    }
}
