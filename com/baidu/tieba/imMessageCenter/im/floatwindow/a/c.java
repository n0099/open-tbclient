package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point cuZ;
    private Point cva;
    private Point cvb;
    private final int cvc;
    private final int cvd;
    private a cve;
    private int cvf;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void ajI();
    }

    private int jP(int i) {
        return (int) (((this.k * i) + this.cuZ.y) - (this.k * this.cuZ.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.cvb.equals(this.cva)) {
            switch (this.cvf) {
                case 0:
                    ajP();
                    break;
                case 1:
                    ajR();
                    break;
                case 2:
                    ajQ();
                    break;
                case 3:
                    ajS();
                    break;
                case 4:
                    ajT();
                    break;
                case 5:
                    ajU();
                    break;
            }
            return false;
        }
        if (this.cve != null) {
            this.cve.ajI();
        }
        return true;
    }

    private void ajP() {
        this.cvb.y += this.cvd;
        if (this.cvb.y > this.cva.y) {
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajQ() {
        this.cvb.x += this.cvc;
        if (this.cvb.x > this.cva.x) {
            this.cvb.x = this.cva.x;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajR() {
        this.cvb.y -= this.cvd;
        if (this.cvb.y < this.cva.y) {
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajS() {
        this.cvb.x -= this.cvc;
        if (this.cvb.x < this.cva.x) {
            this.cvb.x = this.cva.x;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajT() {
        this.cvb.x -= this.cvc;
        this.cvb.y = jP(this.cvb.x);
        if (this.cvb.x < this.cva.x && this.cvb.y < this.cva.y) {
            this.cvb.x = this.cva.x;
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajU() {
        this.cvb.x += this.cvc;
        this.cvb.y = jP(this.cvb.x);
        if (this.cvb.x > this.cva.x && this.cvb.y > this.cva.y) {
            this.cvb.x = this.cva.x;
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }
}
