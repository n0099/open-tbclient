package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean kzA;
    private boolean kzB;
    private Runnable kzC = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.kzA = false;
        }
    };
    private Runnable kzD = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.kzB = false;
        }
    };

    public void onPrepared() {
        this.kzB = true;
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kzD, 500L);
    }

    public void cQZ() {
        this.kzA = true;
    }

    public void cRa() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzC);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kzC, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.kzA && !this.kzB) {
            iVar.cyk();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.kzA && !this.kzB) {
            iVar.cyl();
            this.kzA = false;
            this.kzB = false;
            Qq();
        }
    }

    public void Qq() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzC);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzD);
    }
}
