package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gDZ;
    private boolean gEa;
    private Runnable gEb = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gDZ = false;
        }
    };
    private Runnable gEc = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gEa = false;
        }
    };

    public void onPrepared() {
        this.gEa = true;
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gEc, 500L);
    }

    public void bqX() {
        this.gDZ = true;
    }

    public void bqY() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gEb);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gEb, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.i.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gDZ && !this.gEa) {
            iVar.aVb();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gDZ && !this.gEa) {
            iVar.aVc();
            this.gDZ = false;
            this.gEa = false;
            bqZ();
        }
    }

    public void bqZ() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gEb);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gEc);
    }
}
