package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gtB;
    private boolean gtC;
    private Runnable gtD = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gtB = false;
        }
    };
    private Runnable gtE = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gtC = false;
        }
    };

    public void onPrepared() {
        this.gtC = true;
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gtE, 500L);
    }

    public void bkr() {
        this.gtB = true;
    }

    public void bks() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtD);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gtD, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.i.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gtB && !this.gtC) {
            iVar.aVl();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gtB && !this.gtC) {
            iVar.aVm();
            this.gtB = false;
            this.gtC = false;
            bkt();
        }
    }

    public void bkt() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtD);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtE);
    }
}
