package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gHW;
    private boolean gHX;
    private Runnable gHY = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gHW = false;
        }
    };
    private Runnable gHZ = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gHX = false;
        }
    };

    public void onPrepared() {
        this.gHX = true;
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHZ, 500L);
    }

    public void btg() {
        this.gHW = true;
    }

    public void bth() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHY);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gHY, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gHW && !this.gHX) {
            iVar.bdK();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gHW && !this.gHX) {
            iVar.bdL();
            this.gHW = false;
            this.gHX = false;
            bti();
        }
    }

    public void bti() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHY);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gHZ);
    }
}
