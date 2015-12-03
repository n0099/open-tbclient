package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point caW;
    private Point caX;
    private Point caY;
    private final int caZ;
    private final int cba;
    private a cbb;
    private int cbc;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void abQ();
    }

    private int iH(int i) {
        return (int) (((this.k * i) + this.caW.y) - (this.k * this.caW.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.caY.equals(this.caX)) {
            switch (this.cbc) {
                case 0:
                    abX();
                    break;
                case 1:
                    abZ();
                    break;
                case 2:
                    abY();
                    break;
                case 3:
                    aca();
                    break;
                case 4:
                    acb();
                    break;
                case 5:
                    acc();
                    break;
            }
            return false;
        }
        if (this.cbb != null) {
            this.cbb.abQ();
        }
        return true;
    }

    private void abX() {
        this.caY.y += this.cba;
        if (this.caY.y > this.caX.y) {
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void abY() {
        this.caY.x += this.caZ;
        if (this.caY.x > this.caX.x) {
            this.caY.x = this.caX.x;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void abZ() {
        this.caY.y -= this.cba;
        if (this.caY.y < this.caX.y) {
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void aca() {
        this.caY.x -= this.caZ;
        if (this.caY.x < this.caX.x) {
            this.caY.x = this.caX.x;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void acb() {
        this.caY.x -= this.caZ;
        this.caY.y = iH(this.caY.x);
        if (this.caY.x < this.caX.x && this.caY.y < this.caX.y) {
            this.caY.x = this.caX.x;
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void acc() {
        this.caY.x += this.caZ;
        this.caY.y = iH(this.caY.x);
        if (this.caY.x > this.caX.x && this.caY.y > this.caX.y) {
            this.caY.x = this.caX.x;
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }
}
