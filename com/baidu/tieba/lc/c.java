package com.baidu.tieba.lc;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.lc.a kVS;

    private c() {
    }

    public static c dcU() {
        return a.kVT;
    }

    public void ts(boolean z) {
        if (this.kVS != null) {
            this.kVS.cancel();
            this.kVS = null;
        }
        this.kVS = new com.baidu.tieba.lc.a(z);
        this.kVS.execute(new String[0]);
    }

    public void onDestroy() {
        if (this.kVS != null) {
            this.kVS.cancel();
            this.kVS = null;
        }
    }

    /* loaded from: classes.dex */
    private static class a {
        private static c kVT = new c();
    }
}
