package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean jxG;
    private boolean jxH;
    private Runnable jxI = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.jxG = false;
        }
    };
    private Runnable jxJ = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.jxH = false;
        }
    };

    public void onPrepared() {
        this.jxH = true;
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jxJ, 500L);
    }

    public void czx() {
        this.jxG = true;
    }

    public void czy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxI);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jxI, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.jxG && !this.jxH) {
            iVar.chc();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.jxG && !this.jxH) {
            iVar.chd();
            this.jxG = false;
            this.jxH = false;
            Gr();
        }
    }

    public void Gr() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxI);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jxJ);
    }
}
