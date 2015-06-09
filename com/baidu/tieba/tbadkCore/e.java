package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class e {
    private long aFu;
    private boolean coA;
    private final w cou;
    private aa cov;
    private z cow;
    private boolean cox;
    private i coy;
    private f coz;

    public void fb(boolean z) {
        this.cox = z;
    }

    public void clear() {
        if (this.coy != null) {
            this.coy.cancel();
            this.coy = null;
        }
        if (this.coz != null) {
            this.coz.cancel();
            this.coz = null;
        }
    }
}
