package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kCE;

    private c() {
    }

    public static c cYA() {
        return a.kCF;
    }

    public void sM(boolean z) {
        if (this.kCE != null) {
            this.kCE.cancel();
            this.kCE = null;
        }
        this.kCE = new com.baidu.tieba.lc.a(z);
        this.kCE.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kCE != null) {
            this.kCE.cancel();
            this.kCE = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kCF = new c();
    }
}
