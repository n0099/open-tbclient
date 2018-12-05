package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gEb;
    private boolean gEc;
    private Runnable gEd = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gEb = false;
        }
    };
    private Runnable gEe = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gEc = false;
        }
    };

    public void onPrepared() {
        this.gEc = true;
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gEe, 500L);
    }

    public void brM() {
        this.gEb = true;
    }

    public void brN() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gEd);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gEd, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gEb && !this.gEc) {
            iVar.bcx();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gEb && !this.gEc) {
            iVar.bcy();
            this.gEb = false;
            this.gEc = false;
            brO();
        }
    }

    public void brO() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gEd);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gEe);
    }
}
