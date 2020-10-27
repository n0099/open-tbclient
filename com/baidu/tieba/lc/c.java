package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kwJ;

    private c() {
    }

    public static c cVZ() {
        return a.kwK;
    }

    public void sD(boolean z) {
        if (this.kwJ != null) {
            this.kwJ.cancel();
            this.kwJ = null;
        }
        this.kwJ = new com.baidu.tieba.lc.a(z);
        this.kwJ.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kwJ != null) {
            this.kwJ.cancel();
            this.kwJ = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kwK = new c();
    }
}
