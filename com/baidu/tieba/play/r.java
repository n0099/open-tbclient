package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean izR;
    private boolean izS;
    private Runnable izT = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.izR = false;
        }
    };
    private Runnable izU = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.izS = false;
        }
    };

    public void onPrepared() {
        this.izS = true;
        com.baidu.adp.lib.g.e.iK().postDelayed(this.izU, 500L);
    }

    public void cfB() {
        this.izR = true;
    }

    public void cfC() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izT);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.izT, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.izR && !this.izS) {
            iVar.bPI();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.izR && !this.izS) {
            iVar.bPJ();
            this.izR = false;
            this.izS = false;
            cfD();
        }
    }

    public void cfD() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izT);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izU);
    }
}
