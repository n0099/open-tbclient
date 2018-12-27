package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gGS;
    private boolean gGT;
    private Runnable gGU = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gGS = false;
        }
    };
    private Runnable gGV = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gGT = false;
        }
    };

    public void onPrepared() {
        this.gGT = true;
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gGV, 500L);
    }

    public void bsx() {
        this.gGS = true;
    }

    public void bsy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGU);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gGU, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gGS && !this.gGT) {
            iVar.bdk();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gGS && !this.gGT) {
            iVar.bdl();
            this.gGS = false;
            this.gGT = false;
            bsz();
        }
    }

    public void bsz() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGU);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGV);
    }
}
