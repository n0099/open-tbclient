package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int dpe;
    private a dpf;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void fb(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.dpe = i;
    }

    public void ma(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.dpf = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.dpe != this.end) {
            if (this.end > this.start) {
                this.dpe += this.speed;
                if (this.dpe > this.end) {
                    this.dpe = this.end;
                }
            } else {
                this.dpe -= this.speed;
                if (this.dpe < this.end) {
                    this.dpe = this.end;
                }
            }
            if (this.dpf != null) {
                this.dpf.fb(this.dpe);
            }
            return false;
        }
        return true;
    }
}
