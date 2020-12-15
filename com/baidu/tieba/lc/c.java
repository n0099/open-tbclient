package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kQn;

    private c() {
    }

    public static c ddi() {
        return a.kQo;
    }

    public void tr(boolean z) {
        if (this.kQn != null) {
            this.kQn.cancel();
            this.kQn = null;
        }
        this.kQn = new com.baidu.tieba.lc.a(z);
        this.kQn.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kQn != null) {
            this.kQn.cancel();
            this.kQn = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kQo = new c();
    }
}
