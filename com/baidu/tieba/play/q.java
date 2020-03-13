package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean jwh;
    private boolean jwi;
    private Runnable jwj = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.jwh = false;
        }
    };
    private Runnable jwk = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.jwi = false;
        }
    };

    public void onPrepared() {
        this.jwi = true;
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jwk, 500L);
    }

    public void cze() {
        this.jwh = true;
    }

    public void czf() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwj);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jwj, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.jwh && !this.jwi) {
            iVar.cgI();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.jwh && !this.jwi) {
            iVar.cgJ();
            this.jwh = false;
            this.jwi = false;
            Gm();
        }
    }

    public void Gm() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwj);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwk);
    }
}
