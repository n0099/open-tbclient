package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kQl;

    private c() {
    }

    public static c ddh() {
        return a.kQm;
    }

    public void tr(boolean z) {
        if (this.kQl != null) {
            this.kQl.cancel();
            this.kQl = null;
        }
        this.kQl = new com.baidu.tieba.lc.a(z);
        this.kQl.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kQl != null) {
            this.kQl.cancel();
            this.kQl = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kQm = new c();
    }
}
