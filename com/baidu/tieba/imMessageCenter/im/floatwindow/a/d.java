package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point btI;
    private Point btJ;
    private Point btK;
    private final int btL;
    private final int btM;
    private e btN;
    private int btO;
    private float k;

    private int gM(int i) {
        return (int) (((this.k * i) + this.btI.y) - (this.k * this.btI.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.btK.equals(this.btJ)) {
            switch (this.btO) {
                case 0:
                    Wi();
                    break;
                case 1:
                    Wk();
                    break;
                case 2:
                    Wj();
                    break;
                case 3:
                    Wl();
                    break;
                case 4:
                    Wm();
                    break;
                case 5:
                    Wn();
                    break;
            }
            return false;
        }
        if (this.btN != null) {
            this.btN.Wb();
        }
        return true;
    }

    private void Wi() {
        this.btK.y += this.btM;
        if (this.btK.y > this.btJ.y) {
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wj() {
        this.btK.x += this.btL;
        if (this.btK.x > this.btJ.x) {
            this.btK.x = this.btJ.x;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wk() {
        this.btK.y -= this.btM;
        if (this.btK.y < this.btJ.y) {
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wl() {
        this.btK.x -= this.btL;
        if (this.btK.x < this.btJ.x) {
            this.btK.x = this.btJ.x;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wm() {
        this.btK.x -= this.btL;
        this.btK.y = gM(this.btK.x);
        if (this.btK.x < this.btJ.x && this.btK.y < this.btJ.y) {
            this.btK.x = this.btJ.x;
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wn() {
        this.btK.x += this.btL;
        this.btK.y = gM(this.btK.x);
        if (this.btK.x > this.btJ.x && this.btK.y > this.btJ.y) {
            this.btK.x = this.btJ.x;
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }
}
