package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int cfh;
    private a cfi;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eC(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.cfh = i;
    }

    public void jh(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.cfi = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.cfh != this.end) {
            if (this.end > this.start) {
                this.cfh += this.speed;
                if (this.cfh > this.end) {
                    this.cfh = this.end;
                }
            } else {
                this.cfh -= this.speed;
                if (this.cfh < this.end) {
                    this.cfh = this.end;
                }
            }
            if (this.cfi != null) {
                this.cfi.eC(this.cfh);
            }
            return false;
        }
        return true;
    }
}
