package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int bLw;
    private int bLx;
    private a bLy;
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
        this.bLx = i;
    }

    public void hH(int i) {
        this.bLw = i;
    }

    public void a(a aVar) {
        this.bLy = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.bLx != this.bLw) {
            if (this.bLw > this.start) {
                this.bLx += this.speed;
                if (this.bLx > this.bLw) {
                    this.bLx = this.bLw;
                }
            } else {
                this.bLx -= this.speed;
                if (this.bLx < this.bLw) {
                    this.bLx = this.bLw;
                }
            }
            if (this.bLy != null) {
                this.bLy.ew(this.bLx);
            }
            return false;
        }
        return true;
    }
}
