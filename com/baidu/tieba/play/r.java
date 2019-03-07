package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean hYe;
    private boolean hYf;
    private Runnable hYg = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.hYe = false;
        }
    };
    private Runnable hYh = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.hYf = false;
        }
    };

    public void onPrepared() {
        this.hYf = true;
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hYh, 500L);
    }

    public void bTB() {
        this.hYe = true;
    }

    public void bTC() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYg);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hYg, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.hYe && !this.hYf) {
            iVar.bEn();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.hYe && !this.hYf) {
            iVar.bEo();
            this.hYe = false;
            this.hYf = false;
            bTD();
        }
    }

    public void bTD() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYg);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYh);
    }
}
