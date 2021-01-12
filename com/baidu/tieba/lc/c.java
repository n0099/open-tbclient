package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kRn;

    private c() {
    }

    public static c cZc() {
        return a.kRo;
    }

    public void to(boolean z) {
        if (this.kRn != null) {
            this.kRn.cancel();
            this.kRn = null;
        }
        this.kRn = new com.baidu.tieba.lc.a(z);
        this.kRn.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kRn != null) {
            this.kRn.cancel();
            this.kRn = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kRo = new c();
    }
}
