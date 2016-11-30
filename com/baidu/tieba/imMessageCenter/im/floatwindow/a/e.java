package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int dwj;
    private a dwk;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void fd(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.dwj = i;
    }

    public void mq(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.dwk = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.dwj != this.end) {
            if (this.end > this.start) {
                this.dwj += this.speed;
                if (this.dwj > this.end) {
                    this.dwj = this.end;
                }
            } else {
                this.dwj -= this.speed;
                if (this.dwj < this.end) {
                    this.dwj = this.end;
                }
            }
            if (this.dwk != null) {
                this.dwk.fd(this.dwj);
            }
            return false;
        }
        return true;
    }
}
