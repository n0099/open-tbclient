package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kkm;

    private c() {
    }

    public static c cSS() {
        return a.kkn;
    }

    public void sl(boolean z) {
        if (this.kkm != null) {
            this.kkm.cancel();
            this.kkm = null;
        }
        this.kkm = new com.baidu.tieba.lc.a(z);
        this.kkm.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kkm != null) {
            this.kkm.cancel();
            this.kkm = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kkn = new c();
    }
}
