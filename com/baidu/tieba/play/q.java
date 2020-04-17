package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean khB;
    private boolean khC;
    private Runnable khD = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.khB = false;
        }
    };
    private Runnable khE = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.khC = false;
        }
    };

    public void onPrepared() {
        this.khC = true;
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khE, 500L);
    }

    public void cKc() {
        this.khB = true;
    }

    public void cKd() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khD);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khD, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.khB && !this.khC) {
            iVar.crJ();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.khB && !this.khC) {
            iVar.crK();
            this.khB = false;
            this.khC = false;
            Oe();
        }
    }

    public void Oe() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khD);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khE);
    }
}
