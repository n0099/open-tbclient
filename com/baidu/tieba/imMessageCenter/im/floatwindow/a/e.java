package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int cjG;
    private a cjH;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eW(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.cjG = i;
    }

    public void jF(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.cjH = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.cjG != this.end) {
            if (this.end > this.start) {
                this.cjG += this.speed;
                if (this.cjG > this.end) {
                    this.cjG = this.end;
                }
            } else {
                this.cjG -= this.speed;
                if (this.cjG < this.end) {
                    this.cjG = this.end;
                }
            }
            if (this.cjH != null) {
                this.cjH.eW(this.cjG);
            }
            return false;
        }
        return true;
    }
}
