package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int cvj;
    private a cvk;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eJ(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.cvj = i;
    }

    public void jQ(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.cvk = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.cvj != this.end) {
            if (this.end > this.start) {
                this.cvj += this.speed;
                if (this.cvj > this.end) {
                    this.cvj = this.end;
                }
            } else {
                this.cvj -= this.speed;
                if (this.cvj < this.end) {
                    this.cvj = this.end;
                }
            }
            if (this.cvk != null) {
                this.cvk.eJ(this.cvj);
            }
            return false;
        }
        return true;
    }
}
