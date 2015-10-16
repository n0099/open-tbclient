package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int bLH;
    private int bLI;
    private a bLJ;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void ew(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.bLI = i;
    }

    public void hH(int i) {
        this.bLH = i;
    }

    public void a(a aVar) {
        this.bLJ = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.bLI != this.bLH) {
            if (this.bLH > this.start) {
                this.bLI += this.speed;
                if (this.bLI > this.bLH) {
                    this.bLI = this.bLH;
                }
            } else {
                this.bLI -= this.speed;
                if (this.bLI < this.bLH) {
                    this.bLI = this.bLH;
                }
            }
            if (this.bLJ != null) {
                this.bLJ.ew(this.bLI);
            }
            return false;
        }
        return true;
    }
}
