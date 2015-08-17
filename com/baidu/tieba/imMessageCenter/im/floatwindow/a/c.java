package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point bHA;
    private Point bHB;
    private Point bHC;
    private final int bHD;
    private final int bHE;
    private a bHF;
    private int bHG;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void XJ();

        void a(Point point);
    }

    private int hq(int i) {
        return (int) (((this.k * i) + this.bHA.y) - (this.k * this.bHA.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.bHC.equals(this.bHB)) {
            switch (this.bHG) {
                case 0:
                    XQ();
                    break;
                case 1:
                    XS();
                    break;
                case 2:
                    XR();
                    break;
                case 3:
                    XT();
                    break;
                case 4:
                    XU();
                    break;
                case 5:
                    XV();
                    break;
            }
            return false;
        }
        if (this.bHF != null) {
            this.bHF.XJ();
        }
        return true;
    }

    private void XQ() {
        this.bHC.y += this.bHE;
        if (this.bHC.y > this.bHB.y) {
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XR() {
        this.bHC.x += this.bHD;
        if (this.bHC.x > this.bHB.x) {
            this.bHC.x = this.bHB.x;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XS() {
        this.bHC.y -= this.bHE;
        if (this.bHC.y < this.bHB.y) {
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XT() {
        this.bHC.x -= this.bHD;
        if (this.bHC.x < this.bHB.x) {
            this.bHC.x = this.bHB.x;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XU() {
        this.bHC.x -= this.bHD;
        this.bHC.y = hq(this.bHC.x);
        if (this.bHC.x < this.bHB.x && this.bHC.y < this.bHB.y) {
            this.bHC.x = this.bHB.x;
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XV() {
        this.bHC.x += this.bHD;
        this.bHC.y = hq(this.bHC.x);
        if (this.bHC.x > this.bHB.x && this.bHC.y > this.bHB.y) {
            this.bHC.x = this.bHB.x;
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }
}
