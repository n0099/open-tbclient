package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point btJ;
    private Point btK;
    private Point btL;
    private final int btM;
    private final int btN;
    private e btO;
    private int btP;
    private float k;

    private int gM(int i) {
        return (int) (((this.k * i) + this.btJ.y) - (this.k * this.btJ.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.btL.equals(this.btK)) {
            switch (this.btP) {
                case 0:
                    Wj();
                    break;
                case 1:
                    Wl();
                    break;
                case 2:
                    Wk();
                    break;
                case 3:
                    Wm();
                    break;
                case 4:
                    Wn();
                    break;
                case 5:
                    Wo();
                    break;
            }
            return false;
        }
        if (this.btO != null) {
            this.btO.Wc();
        }
        return true;
    }

    private void Wj() {
        this.btL.y += this.btN;
        if (this.btL.y > this.btK.y) {
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wk() {
        this.btL.x += this.btM;
        if (this.btL.x > this.btK.x) {
            this.btL.x = this.btK.x;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wl() {
        this.btL.y -= this.btN;
        if (this.btL.y < this.btK.y) {
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wm() {
        this.btL.x -= this.btM;
        if (this.btL.x < this.btK.x) {
            this.btL.x = this.btK.x;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wn() {
        this.btL.x -= this.btM;
        this.btL.y = gM(this.btL.x);
        if (this.btL.x < this.btK.x && this.btL.y < this.btK.y) {
            this.btL.x = this.btK.x;
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wo() {
        this.btL.x += this.btM;
        this.btL.y = gM(this.btL.x);
        if (this.btL.x > this.btK.x && this.btL.y > this.btK.y) {
            this.btL.x = this.btK.x;
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }
}
