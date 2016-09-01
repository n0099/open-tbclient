package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a doZ;
    private int dpa;
    private float dpb;
    private float dpc;
    private final long dpd;
    private float k;
    private long startTime;
    private Point doU = new Point();
    private Point doW = new Point();
    private Point doV = new Point();

    public d(long j) {
        this.dpd = j;
    }

    public void a(c.a aVar) {
        this.doZ = aVar;
    }

    public void a(Point point, Point point2) {
        this.doU.x = point.x;
        this.doU.y = point.y;
        this.doW.x = point.x;
        this.doW.y = point.y;
        this.doV.x = point2.x;
        this.doV.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.dpc = Math.abs(point2.y - point.y) / ((float) this.dpd);
            if (point2.y > point.y) {
                this.dpa = 0;
            } else {
                this.dpa = 1;
            }
        } else if (point.y == point2.y) {
            this.dpb = Math.abs(point2.x - point.x) / ((float) this.dpd);
            if (point2.x > point.x) {
                this.dpa = 2;
            } else {
                this.dpa = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.dpb = Math.abs(f) / ((float) this.dpd);
            if (f > 0.0f) {
                this.dpa = 5;
            } else {
                this.dpa = 4;
            }
        }
    }

    private int lZ(int i) {
        return (int) (((this.k * i) + this.doU.y) - (this.k * this.doU.x));
    }

    private long axL() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.doW.y = (int) (this.doU.y + (this.dpc * ((float) axL())));
        if (this.doW.y > this.doV.y) {
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axG() {
        this.doW.x = (int) (this.doU.x + (this.dpb * ((float) axL())));
        if (this.doW.x > this.doV.x) {
            this.doW.x = this.doV.x;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axH() {
        this.doW.y = (int) (this.doU.y - (this.dpc * ((float) axL())));
        if (this.doW.y < this.doV.y) {
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axI() {
        this.doW.x = (int) (this.doU.x - (this.dpb * ((float) axL())));
        if (this.doW.x < this.doV.x) {
            this.doW.x = this.doV.x;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axJ() {
        boolean z = true;
        this.doW.x = (int) (this.doU.x - (this.dpb * ((float) axL())));
        this.doW.y = lZ(this.doW.x);
        if (this.doU.y <= this.doV.y ? this.doW.y <= this.doV.y : this.doW.y >= this.doV.y) {
            z = false;
        }
        if (this.doW.x < this.doV.x || z) {
            this.doW.x = this.doV.x;
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }

    private void axK() {
        boolean z = true;
        this.doW.x = (int) (this.doU.x + (this.dpb * ((float) axL())));
        this.doW.y = lZ(this.doW.x);
        if (this.doU.y <= this.doV.y ? this.doW.y <= this.doV.y : this.doW.y >= this.doV.y) {
            z = false;
        }
        if (this.doW.x > this.doV.x || z) {
            this.doW.x = this.doV.x;
            this.doW.y = this.doV.y;
        }
        if (this.doZ != null) {
            this.doZ.a(this.doW);
        }
    }
}
