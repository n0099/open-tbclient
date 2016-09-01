package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point doU;
    private Point doV;
    private Point doW;
    private final int doX;
    private final int doY;
    private a doZ;
    private int dpa;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void axy();
    }

    private int lZ(int i) {
        return (int) (((this.k * i) + this.doU.y) - (this.k * this.doU.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.doW.equals(this.doV)) {
            switch (this.dpa) {
                case 0:
                    axF();
                    break;
                case 1:
                    axH();
                    break;
                case 2:
                    axG();
                    break;
                case 3:
                    axI();
                    break;
                case 4:
                    axJ();
                    break;
                case 5:
                    axK();
                    break;
            }
            return false;
        }
        if (this.doZ != null) {
            this.doZ.axy();
        }
        return true;
    }

    private void axF() {
        this.doW.y += this.doY;
        if (this.doW.y > this.doV.y) {
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axG() {
        this.doW.x += this.doX;
        if (this.doW.x > this.doV.x) {
            this.doW.x = this.doV.x;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axH() {
        this.doW.y -= this.doY;
        if (this.doW.y < this.doV.y) {
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axI() {
        this.doW.x -= this.doX;
        if (this.doW.x < this.doV.x) {
            this.doW.x = this.doV.x;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axJ() {
        this.doW.x -= this.doX;
        this.doW.y = lZ(this.doW.x);
        if (this.doW.x < this.doV.x && this.doW.y < this.doV.y) {
            this.doW.x = this.doV.x;
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axK() {
        this.doW.x += this.doX;
        this.doW.y = lZ(this.doW.x);
        if (this.doW.x > this.doV.x && this.doW.y > this.doV.y) {
            this.doW.x = this.doV.x;
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }
}
