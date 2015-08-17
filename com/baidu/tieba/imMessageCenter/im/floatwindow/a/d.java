package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a bHF;
    private int bHG;
    private float bHH;
    private float bHI;
    private final long bHJ;
    private float k;
    private long startTime;
    private Point bHA = new Point();
    private Point bHC = new Point();
    private Point bHB = new Point();

    public d(long j) {
        this.bHJ = j;
    }

    public void a(c.a aVar) {
        this.bHF = aVar;
    }

    public void a(Point point, Point point2) {
        this.bHA.x = point.x;
        this.bHA.y = point.y;
        this.bHC.x = point.x;
        this.bHC.y = point.y;
        this.bHB.x = point2.x;
        this.bHB.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.bHI = Math.abs(point2.y - point.y) / ((float) this.bHJ);
            if (point2.y > point.y) {
                this.bHG = 0;
            } else {
                this.bHG = 1;
            }
        } else if (point.y == point2.y) {
            this.bHH = Math.abs(point2.x - point.x) / ((float) this.bHJ);
            if (point2.x > point.x) {
                this.bHG = 2;
            } else {
                this.bHG = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.bHH = Math.abs(f) / ((float) this.bHJ);
            if (f > 0.0f) {
                this.bHG = 5;
            } else {
                this.bHG = 4;
            }
        }
    }

    private int hq(int i) {
        return (int) (((this.k * i) + this.bHA.y) - (this.k * this.bHA.x));
    }

    private long XW() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.bHC.y = (int) (this.bHA.y + (this.bHI * ((float) XW())));
        if (this.bHC.y > this.bHB.y) {
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XR() {
        this.bHC.x = (int) (this.bHA.x + (this.bHH * ((float) XW())));
        if (this.bHC.x > this.bHB.x) {
            this.bHC.x = this.bHB.x;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XS() {
        this.bHC.y = (int) (this.bHA.y - (this.bHI * ((float) XW())));
        if (this.bHC.y < this.bHB.y) {
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XT() {
        this.bHC.x = (int) (this.bHA.x - (this.bHH * ((float) XW())));
        if (this.bHC.x < this.bHB.x) {
            this.bHC.x = this.bHB.x;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XU() {
        boolean z = true;
        this.bHC.x = (int) (this.bHA.x - (this.bHH * ((float) XW())));
        this.bHC.y = hq(this.bHC.x);
        if (this.bHA.y <= this.bHB.y ? this.bHC.y <= this.bHB.y : this.bHC.y >= this.bHB.y) {
            z = false;
        }
        if (this.bHC.x < this.bHB.x || z) {
            this.bHC.x = this.bHB.x;
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }

    private void XV() {
        boolean z = true;
        this.bHC.x = (int) (this.bHA.x + (this.bHH * ((float) XW())));
        this.bHC.y = hq(this.bHC.x);
        if (this.bHA.y <= this.bHB.y ? this.bHC.y <= this.bHB.y : this.bHC.y >= this.bHB.y) {
            z = false;
        }
        if (this.bHC.x > this.bHB.x || z) {
            this.bHC.x = this.bHB.x;
            this.bHC.y = this.bHB.y;
        }
        if (this.bHF != null) {
            this.bHF.a(this.bHC);
        }
    }
}
