package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean hXM;
    private boolean hXN;
    private Runnable hXO = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.hXM = false;
        }
    };
    private Runnable hXP = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.hXN = false;
        }
    };

    public void onPrepared() {
        this.hXN = true;
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXP, 500L);
    }

    public void bTA() {
        this.hXM = true;
    }

    public void bTB() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXO);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hXO, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.hXM && !this.hXN) {
            iVar.bEk();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.hXM && !this.hXN) {
            iVar.bEl();
            this.hXM = false;
            this.hXN = false;
            bTC();
        }
    }

    public void bTC() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXO);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hXP);
    }
}
