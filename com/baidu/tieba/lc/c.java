package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kZp;

    private c() {
    }

    public static c dba() {
        return a.kZq;
    }

    public void tB(boolean z) {
        if (this.kZp != null) {
            this.kZp.cancel();
            this.kZp = null;
        }
        this.kZp = new com.baidu.tieba.lc.a(z);
        this.kZp.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kZp != null) {
            this.kZp.cancel();
            this.kZp = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kZq = new c();
    }
}
