package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kCT;

    private c() {
    }

    public static c cXW() {
        return a.kCU;
    }

    public void sP(boolean z) {
        if (this.kCT != null) {
            this.kCT.cancel();
            this.kCT = null;
        }
        this.kCT = new com.baidu.tieba.lc.a(z);
        this.kCT.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kCT != null) {
            this.kCT.cancel();
            this.kCT = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kCU = new c();
    }
}
