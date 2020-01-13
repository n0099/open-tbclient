package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean juY;
    private boolean juZ;
    private Runnable jva = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.juY = false;
        }
    };
    private Runnable jvb = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.juZ = false;
        }
    };

    public void onPrepared() {
        this.juZ = true;
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvb, 500L);
    }

    public void cxF() {
        this.juY = true;
    }

    public void cxG() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jva);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jva, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.juY && !this.juZ) {
            iVar.cfb();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.juY && !this.juZ) {
            iVar.cfc();
            this.juY = false;
            this.juZ = false;
            DV();
        }
    }

    public void DV() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jva);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvb);
    }
}
