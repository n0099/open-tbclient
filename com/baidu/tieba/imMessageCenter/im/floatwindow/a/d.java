package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a cbb;
    private int cbc;
    private float cbd;
    private float cbe;
    private final long cbf;
    private float k;
    private long startTime;
    private Point caW = new Point();
    private Point caY = new Point();
    private Point caX = new Point();

    public d(long j) {
        this.cbf = j;
    }

    public void a(c.a aVar) {
        this.cbb = aVar;
    }

    public void a(Point point, Point point2) {
        this.caW.x = point.x;
        this.caW.y = point.y;
        this.caY.x = point.x;
        this.caY.y = point.y;
        this.caX.x = point2.x;
        this.caX.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.cbe = Math.abs(point2.y - point.y) / ((float) this.cbf);
            if (point2.y > point.y) {
                this.cbc = 0;
            } else {
                this.cbc = 1;
            }
        } else if (point.y == point2.y) {
            this.cbd = Math.abs(point2.x - point.x) / ((float) this.cbf);
            if (point2.x > point.x) {
                this.cbc = 2;
            } else {
                this.cbc = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.cbd = Math.abs(f) / ((float) this.cbf);
            if (f > 0.0f) {
                this.cbc = 5;
            } else {
                this.cbc = 4;
            }
        }
    }

    private int iH(int i) {
        return (int) (((this.k * i) + this.caW.y) - (this.k * this.caW.x));
    }

    private long acd() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.caY.y = (int) (this.caW.y + (this.cbe * ((float) acd())));
        if (this.caY.y > this.caX.y) {
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void abY() {
        this.caY.x = (int) (this.caW.x + (this.cbd * ((float) acd())));
        if (this.caY.x > this.caX.x) {
            this.caY.x = this.caX.x;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void abZ() {
        this.caY.y = (int) (this.caW.y - (this.cbe * ((float) acd())));
        if (this.caY.y < this.caX.y) {
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void aca() {
        this.caY.x = (int) (this.caW.x - (this.cbd * ((float) acd())));
        if (this.caY.x < this.caX.x) {
            this.caY.x = this.caX.x;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void acb() {
        boolean z = true;
        this.caY.x = (int) (this.caW.x - (this.cbd * ((float) acd())));
        this.caY.y = iH(this.caY.x);
        if (this.caW.y <= this.caX.y ? this.caY.y <= this.caX.y : this.caY.y >= this.caX.y) {
            z = false;
        }
        if (this.caY.x < this.caX.x || z) {
            this.caY.x = this.caX.x;
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }

    private void acc() {
        boolean z = true;
        this.caY.x = (int) (this.caW.x + (this.cbd * ((float) acd())));
        this.caY.y = iH(this.caY.x);
        if (this.caW.y <= this.caX.y ? this.caY.y <= this.caX.y : this.caY.y >= this.caX.y) {
            z = false;
        }
        if (this.caY.x > this.caX.x || z) {
            this.caY.x = this.caX.x;
            this.caY.y = this.caX.y;
        }
        if (this.cbb != null) {
            this.cbb.a(this.caY);
        }
    }
}
