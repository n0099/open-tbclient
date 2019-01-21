package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gHX;
    private boolean gHY;
    private Runnable gHZ = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gHX = false;
        }
    };
    private Runnable gIa = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gHY = false;
        }
    };

    public void onPrepared() {
        this.gHY = true;
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gIa, 500L);
    }

    public void btg() {
        this.gHX = true;
    }

    public void bth() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHZ);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHZ, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gHX && !this.gHY) {
            iVar.bdK();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gHX && !this.gHY) {
            iVar.bdL();
            this.gHX = false;
            this.gHY = false;
            bti();
        }
    }

    public void bti() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gIa);
    }
}
