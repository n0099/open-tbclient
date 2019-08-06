package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean ixP;
    private boolean ixQ;
    private Runnable ixR = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.ixP = false;
        }
    };
    private Runnable ixS = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.ixQ = false;
        }
    };

    public void onPrepared() {
        this.ixQ = true;
        com.baidu.adp.lib.g.e.iK().postDelayed(this.ixS, 500L);
    }

    public void ceN() {
        this.ixP = true;
    }

    public void ceO() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixR);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.ixR, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.ixP && !this.ixQ) {
            iVar.bOV();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.ixP && !this.ixQ) {
            iVar.bOW();
            this.ixP = false;
            this.ixQ = false;
            ceP();
        }
    }

    public void ceP() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ixS);
    }
}
