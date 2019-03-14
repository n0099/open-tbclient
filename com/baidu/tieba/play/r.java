package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean hXZ;
    private boolean hYa;
    private Runnable hYb = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.hXZ = false;
        }
    };
    private Runnable hYc = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.hYa = false;
        }
    };

    public void onPrepared() {
        this.hYa = true;
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hYc, 500L);
    }

    public void bTE() {
        this.hXZ = true;
    }

    public void bTF() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYb);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hYb, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.hXZ && !this.hYa) {
            iVar.bEn();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.hXZ && !this.hYa) {
            iVar.bEo();
            this.hXZ = false;
            this.hYa = false;
            bTG();
        }
    }

    public void bTG() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYb);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYc);
    }
}
