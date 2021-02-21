package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kZD;

    private c() {
    }

    public static c dbh() {
        return a.kZE;
    }

    public void tB(boolean z) {
        if (this.kZD != null) {
            this.kZD.cancel();
            this.kZD = null;
        }
        this.kZD = new com.baidu.tieba.lc.a(z);
        this.kZD.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kZD != null) {
            this.kZD.cancel();
            this.kZD = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kZE = new c();
    }
}
