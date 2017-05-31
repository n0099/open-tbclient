package com.baidu.tieba.k;
/* loaded from: classes.dex */
public class c {
    private static volatile c fyS = null;
    private b fyT;

    private c() {
        this.fyT = null;
        this.fyT = b.fyR;
    }

    public static c bgd() {
        if (fyS == null) {
            synchronized (c.class) {
                if (fyS == null) {
                    fyS = new c();
                }
            }
        }
        return fyS;
    }

    public b bge() {
        return this.fyT;
    }
}
