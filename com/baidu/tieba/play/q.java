package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean kUD;
    private boolean kUE;
    private Runnable kUF = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.kUD = false;
        }
    };
    private Runnable kUG = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.kUE = false;
        }
    };

    public void onPrepared() {
        this.kUE = true;
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kUG, 500L);
    }

    public void cVH() {
        this.kUD = true;
    }

    public void cVI() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUF);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kUF, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.kUD && !this.kUE) {
            iVar.cCz();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.kUD && !this.kUE) {
            iVar.cCA();
            this.kUD = false;
            this.kUE = false;
            Rw();
        }
    }

    public void Rw() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUF);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kUG);
    }
}
