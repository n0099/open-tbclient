package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean kAG;
    private boolean kAH;
    private Runnable kAI = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.kAG = false;
        }
    };
    private Runnable kAJ = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.kAH = false;
        }
    };

    public void onPrepared() {
        this.kAH = true;
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kAJ, 500L);
    }

    public void cRp() {
        this.kAG = true;
    }

    public void cRq() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAI);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kAI, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.kAG && !this.kAH) {
            iVar.cyB();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.kAG && !this.kAH) {
            iVar.cyC();
            this.kAG = false;
            this.kAH = false;
            Qq();
        }
    }

    public void Qq() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAI);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kAJ);
    }
}
