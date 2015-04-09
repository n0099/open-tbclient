package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class e {
    private long aDr;
    private final w ckt;
    private aa cku;
    private z ckv;
    private boolean ckw;
    private i ckx;
    private f cky;
    private boolean ckz;

    public void eH(boolean z) {
        this.ckw = z;
    }

    public void clear() {
        if (this.ckx != null) {
            this.ckx.cancel();
            this.ckx = null;
        }
        if (this.cky != null) {
            this.cky.cancel();
            this.cky = null;
        }
    }
}
