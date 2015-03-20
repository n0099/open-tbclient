package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point bqI;
    private Point bqJ;
    private Point bqK;
    private final int bqL;
    private final int bqM;
    private e bqN;
    private int bqO;
    private float k;

    private int gt(int i) {
        return (int) (((this.k * i) + this.bqI.y) - (this.k * this.bqI.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.bqK.equals(this.bqJ)) {
            switch (this.bqO) {
                case 0:
                    UE();
                    break;
                case 1:
                    UG();
                    break;
                case 2:
                    UF();
                    break;
                case 3:
                    UH();
                    break;
                case 4:
                    UI();
                    break;
                case 5:
                    UJ();
                    break;
            }
            return false;
        }
        if (this.bqN != null) {
            this.bqN.Ux();
        }
        return true;
    }

    private void UE() {
        this.bqK.y += this.bqM;
        if (this.bqK.y > this.bqJ.y) {
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UF() {
        this.bqK.x += this.bqL;
        if (this.bqK.x > this.bqJ.x) {
            this.bqK.x = this.bqJ.x;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UG() {
        this.bqK.y -= this.bqM;
        if (this.bqK.y < this.bqJ.y) {
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UH() {
        this.bqK.x -= this.bqL;
        if (this.bqK.x < this.bqJ.x) {
            this.bqK.x = this.bqJ.x;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UI() {
        this.bqK.x -= this.bqL;
        this.bqK.y = gt(this.bqK.x);
        if (this.bqK.x < this.bqJ.x && this.bqK.y < this.bqJ.y) {
            this.bqK.x = this.bqJ.x;
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UJ() {
        this.bqK.x += this.bqL;
        this.bqK.y = gt(this.bqK.x);
        if (this.bqK.x > this.bqJ.x && this.bqK.y > this.bqJ.y) {
            this.bqK.x = this.bqJ.x;
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }
}
