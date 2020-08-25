package com.baidu.tieba.q;
/* loaded from: classes14.dex */
public class d {
    private static volatile c lUS;

    public static synchronized c dtr() {
        c cVar;
        synchronized (d.class) {
            if (lUS == null) {
                lUS = new c();
            }
            cVar = lUS;
        }
        return cVar;
    }
}
