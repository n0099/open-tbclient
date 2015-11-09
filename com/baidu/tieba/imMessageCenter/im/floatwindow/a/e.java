package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int bMc;
    private int bMd;
    private a bMe;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eu(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.bMd = i;
    }

    public void hU(int i) {
        this.bMc = i;
    }

    public void a(a aVar) {
        this.bMe = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.bMd != this.bMc) {
            if (this.bMc > this.start) {
                this.bMd += this.speed;
                if (this.bMd > this.bMc) {
                    this.bMd = this.bMc;
                }
            } else {
                this.bMd -= this.speed;
                if (this.bMd < this.bMc) {
                    this.bMd = this.bMc;
                }
            }
            if (this.bMe != null) {
                this.bMe.eu(this.bMd);
            }
            return false;
        }
        return true;
    }
}
