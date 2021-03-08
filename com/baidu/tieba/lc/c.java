package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a lbG;

    private c() {
    }

    public static c dbq() {
        return a.lbH;
    }

    public void tB(boolean z) {
        if (this.lbG != null) {
            this.lbG.cancel();
            this.lbG = null;
        }
        this.lbG = new com.baidu.tieba.lc.a(z);
        this.lbG.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.lbG != null) {
            this.lbG.cancel();
            this.lbG = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c lbH = new c();
    }
}
