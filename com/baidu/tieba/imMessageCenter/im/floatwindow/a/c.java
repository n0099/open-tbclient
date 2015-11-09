package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point bLS;
    private Point bLT;
    private Point bLU;
    private final int bLV;
    private final int bLW;
    private a bLX;
    private int bLY;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void YK();

        void a(Point point);
    }

    private int hT(int i) {
        return (int) (((this.k * i) + this.bLS.y) - (this.k * this.bLS.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.bLU.equals(this.bLT)) {
            switch (this.bLY) {
                case 0:
                    YR();
                    break;
                case 1:
                    YT();
                    break;
                case 2:
                    YS();
                    break;
                case 3:
                    YU();
                    break;
                case 4:
                    YV();
                    break;
                case 5:
                    YW();
                    break;
            }
            return false;
        }
        if (this.bLX != null) {
            this.bLX.YK();
        }
        return true;
    }

    private void YR() {
        this.bLU.y += this.bLW;
        if (this.bLU.y > this.bLT.y) {
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YS() {
        this.bLU.x += this.bLV;
        if (this.bLU.x > this.bLT.x) {
            this.bLU.x = this.bLT.x;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YT() {
        this.bLU.y -= this.bLW;
        if (this.bLU.y < this.bLT.y) {
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YU() {
        this.bLU.x -= this.bLV;
        if (this.bLU.x < this.bLT.x) {
            this.bLU.x = this.bLT.x;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YV() {
        this.bLU.x -= this.bLV;
        this.bLU.y = hT(this.bLU.x);
        if (this.bLU.x < this.bLT.x && this.bLU.y < this.bLT.y) {
            this.bLU.x = this.bLT.x;
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YW() {
        this.bLU.x += this.bLV;
        this.bLU.y = hT(this.bLU.x);
        if (this.bLU.x > this.bLT.x && this.bLU.y > this.bLT.y) {
            this.bLU.x = this.bLT.x;
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }
}
