package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean guW;
    private boolean guX;
    private Runnable guY = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.guW = false;
        }
    };
    private Runnable guZ = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.guX = false;
        }
    };

    public void onPrepared() {
        this.guX = true;
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guZ, 500L);
    }

    public void blD() {
        this.guW = true;
    }

    public void blE() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guY);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.guY, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.i.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.guW && !this.guX) {
            iVar.aWT();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.guW && !this.guX) {
            iVar.aWU();
            this.guW = false;
            this.guX = false;
            blF();
        }
    }

    public void blF() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guY);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.guZ);
    }
}
