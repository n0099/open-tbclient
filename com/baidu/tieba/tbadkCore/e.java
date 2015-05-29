package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class e {
    private long aFt;
    private final w cot;
    private aa cou;
    private z cov;
    private boolean cow;
    private i cox;
    private f coy;
    private boolean coz;

    public void fb(boolean z) {
        this.cow = z;
    }

    public void clear() {
        if (this.cox != null) {
            this.cox.cancel();
            this.cox = null;
        }
        if (this.coy != null) {
            this.coy.cancel();
            this.coy = null;
        }
    }
}
