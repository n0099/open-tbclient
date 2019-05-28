package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean iqv;
    private boolean iqw;
    private Runnable iqx = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.iqv = false;
        }
    };
    private Runnable iqy = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.iqw = false;
        }
    };

    public void onPrepared() {
        this.iqw = true;
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqy, 500L);
    }

    public void cbE() {
        this.iqv = true;
    }

    public void cbF() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqx);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqx, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.iqv && !this.iqw) {
            iVar.bLY();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.iqv && !this.iqw) {
            iVar.bLZ();
            this.iqv = false;
            this.iqw = false;
            cbG();
        }
    }

    public void cbG() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqx);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqy);
    }
}
