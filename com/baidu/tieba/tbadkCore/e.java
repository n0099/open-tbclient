package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class e {
    private long aDj;
    private final w ckd;
    private aa cke;
    private z ckf;
    private boolean ckg;
    private i ckh;
    private f cki;
    private boolean ckj;

    public void eJ(boolean z) {
        this.ckg = z;
    }

    public void clear() {
        if (this.ckh != null) {
            this.ckh.cancel();
            this.ckh = null;
        }
        if (this.cki != null) {
            this.cki.cancel();
            this.cki = null;
        }
    }
}
