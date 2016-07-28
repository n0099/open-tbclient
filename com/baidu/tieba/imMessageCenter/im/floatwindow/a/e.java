package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int ddx;
    private a ddy;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.ddx = i;
    }

    public void lx(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.ddy = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.ddx != this.end) {
            if (this.end > this.start) {
                this.ddx += this.speed;
                if (this.ddx > this.end) {
                    this.ddx = this.end;
                }
            } else {
                this.ddx -= this.speed;
                if (this.ddx < this.end) {
                    this.ddx = this.end;
                }
            }
            if (this.ddy != null) {
                this.ddy.eN(this.ddx);
            }
            return false;
        }
        return true;
    }
}
