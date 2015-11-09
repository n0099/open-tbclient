package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a bLX;
    private int bLY;
    private float bLZ;
    private float bMa;
    private final long bMb;
    private float k;
    private long startTime;
    private Point bLS = new Point();
    private Point bLU = new Point();
    private Point bLT = new Point();

    public d(long j) {
        this.bMb = j;
    }

    public void a(c.a aVar) {
        this.bLX = aVar;
    }

    public void a(Point point, Point point2) {
        this.bLS.x = point.x;
        this.bLS.y = point.y;
        this.bLU.x = point.x;
        this.bLU.y = point.y;
        this.bLT.x = point2.x;
        this.bLT.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.bMa = Math.abs(point2.y - point.y) / ((float) this.bMb);
            if (point2.y > point.y) {
                this.bLY = 0;
            } else {
                this.bLY = 1;
            }
        } else if (point.y == point2.y) {
            this.bLZ = Math.abs(point2.x - point.x) / ((float) this.bMb);
            if (point2.x > point.x) {
                this.bLY = 2;
            } else {
                this.bLY = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.bLZ = Math.abs(f) / ((float) this.bMb);
            if (f > 0.0f) {
                this.bLY = 5;
            } else {
                this.bLY = 4;
            }
        }
    }

    private int hT(int i) {
        return (int) (((this.k * i) + this.bLS.y) - (this.k * this.bLS.x));
    }

    private long YX() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.bLU.y = (int) (this.bLS.y + (this.bMa * ((float) YX())));
        if (this.bLU.y > this.bLT.y) {
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YS() {
        this.bLU.x = (int) (this.bLS.x + (this.bLZ * ((float) YX())));
        if (this.bLU.x > this.bLT.x) {
            this.bLU.x = this.bLT.x;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YT() {
        this.bLU.y = (int) (this.bLS.y - (this.bMa * ((float) YX())));
        if (this.bLU.y < this.bLT.y) {
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YU() {
        this.bLU.x = (int) (this.bLS.x - (this.bLZ * ((float) YX())));
        if (this.bLU.x < this.bLT.x) {
            this.bLU.x = this.bLT.x;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YV() {
        boolean z = true;
        this.bLU.x = (int) (this.bLS.x - (this.bLZ * ((float) YX())));
        this.bLU.y = hT(this.bLU.x);
        if (this.bLS.y <= this.bLT.y ? this.bLU.y <= this.bLT.y : this.bLU.y >= this.bLT.y) {
            z = false;
        }
        if (this.bLU.x < this.bLT.x || z) {
            this.bLU.x = this.bLT.x;
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }

    private void YW() {
        boolean z = true;
        this.bLU.x = (int) (this.bLS.x + (this.bLZ * ((float) YX())));
        this.bLU.y = hT(this.bLU.x);
        if (this.bLS.y <= this.bLT.y ? this.bLU.y <= this.bLT.y : this.bLU.y >= this.bLT.y) {
            z = false;
        }
        if (this.bLU.x > this.bLT.x || z) {
            this.bLU.x = this.bLT.x;
            this.bLU.y = this.bLT.y;
        }
        if (this.bLX != null) {
            this.bLX.a(this.bLU);
        }
    }
}
