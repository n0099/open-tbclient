package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean iqw;
    private boolean iqx;
    private Runnable iqy = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.iqw = false;
        }
    };
    private Runnable iqz = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.iqx = false;
        }
    };

    public void onPrepared() {
        this.iqx = true;
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqz, 500L);
    }

    public void cbF() {
        this.iqw = true;
    }

    public void cbG() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqy);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqy, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.iqw && !this.iqx) {
            iVar.bLZ();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.iqw && !this.iqx) {
            iVar.bMa();
            this.iqw = false;
            this.iqx = false;
            cbH();
        }
    }

    public void cbH() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqy);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqz);
    }
}
