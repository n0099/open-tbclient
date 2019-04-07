package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean hXL;
    private boolean hXM;
    private Runnable hXN = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.hXL = false;
        }
    };
    private Runnable hXO = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.hXM = false;
        }
    };

    public void onPrepared() {
        this.hXM = true;
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXO, 500L);
    }

    public void bTA() {
        this.hXL = true;
    }

    public void bTB() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXN);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXN, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.hXL && !this.hXM) {
            iVar.bEk();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.hXL && !this.hXM) {
            iVar.bEl();
            this.hXL = false;
            this.hXM = false;
            bTC();
        }
    }

    public void bTC() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXN);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXO);
    }
}
