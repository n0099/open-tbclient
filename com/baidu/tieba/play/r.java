package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gtg;
    private boolean gth;
    private Runnable gti = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gtg = false;
        }
    };
    private Runnable gtj = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gth = false;
        }
    };

    public void onPrepared() {
        this.gth = true;
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gtj, 500L);
    }

    public void bkq() {
        this.gtg = true;
    }

    public void bkr() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gti);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gti, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.i.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gtg && !this.gth) {
            iVar.aVg();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gtg && !this.gth) {
            iVar.aVh();
            this.gtg = false;
            this.gth = false;
            bks();
        }
    }

    public void bks() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gti);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gtj);
    }
}
