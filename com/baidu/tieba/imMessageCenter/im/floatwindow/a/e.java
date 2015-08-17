package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int bHK;
    private int bHL;
    private a bHM;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void en(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.bHL = i;
    }

    public void hr(int i) {
        this.bHK = i;
    }

    public void a(a aVar) {
        this.bHM = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.bHL != this.bHK) {
            if (this.bHK > this.start) {
                this.bHL += this.speed;
                if (this.bHL > this.bHK) {
                    this.bHL = this.bHK;
                }
            } else {
                this.bHL -= this.speed;
                if (this.bHL < this.bHK) {
                    this.bHL = this.bHK;
                }
            }
            if (this.bHM != null) {
                this.bHM.en(this.bHL);
            }
            return false;
        }
        return true;
    }
}
