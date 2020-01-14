package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean jvd;
    private boolean jve;
    private Runnable jvf = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.jvd = false;
        }
    };
    private Runnable jvg = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.jve = false;
        }
    };

    public void onPrepared() {
        this.jve = true;
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvg, 500L);
    }

    public void cxH() {
        this.jvd = true;
    }

    public void cxI() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvf);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvf, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.jvd && !this.jve) {
            iVar.cfb();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.jvd && !this.jve) {
            iVar.cfc();
            this.jvd = false;
            this.jve = false;
            DV();
        }
    }

    public void DV() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvf);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvg);
    }
}
