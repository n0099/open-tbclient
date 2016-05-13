package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a cve;
    private int cvf;
    private float cvg;
    private float cvh;
    private final long cvi;
    private float k;
    private long startTime;
    private Point cuZ = new Point();
    private Point cvb = new Point();
    private Point cva = new Point();

    public d(long j) {
        this.cvi = j;
    }

    public void a(c.a aVar) {
        this.cve = aVar;
    }

    public void a(Point point, Point point2) {
        this.cuZ.x = point.x;
        this.cuZ.y = point.y;
        this.cvb.x = point.x;
        this.cvb.y = point.y;
        this.cva.x = point2.x;
        this.cva.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.cvh = Math.abs(point2.y - point.y) / ((float) this.cvi);
            if (point2.y > point.y) {
                this.cvf = 0;
            } else {
                this.cvf = 1;
            }
        } else if (point.y == point2.y) {
            this.cvg = Math.abs(point2.x - point.x) / ((float) this.cvi);
            if (point2.x > point.x) {
                this.cvf = 2;
            } else {
                this.cvf = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.cvg = Math.abs(f) / ((float) this.cvi);
            if (f > 0.0f) {
                this.cvf = 5;
            } else {
                this.cvf = 4;
            }
        }
    }

    private int jO(int i) {
        return (int) (((this.k * i) + this.cuZ.y) - (this.k * this.cuZ.x));
    }

    private long ajX() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.cvb.equals(this.cva)) {
            switch (this.cvf) {
                case 0:
                    ajR();
                    break;
                case 1:
                    ajT();
                    break;
                case 2:
                    ajS();
                    break;
                case 3:
                    ajU();
                    break;
                case 4:
                    ajV();
                    break;
                case 5:
                    ajW();
                    break;
            }
            return false;
        }
        if (this.cve != null) {
            this.cve.ajK();
        }
        return true;
    }

    private void ajR() {
        this.cvb.y = (int) (this.cuZ.y + (this.cvh * ((float) ajX())));
        if (this.cvb.y > this.cva.y) {
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajS() {
        this.cvb.x = (int) (this.cuZ.x + (this.cvg * ((float) ajX())));
        if (this.cvb.x > this.cva.x) {
            this.cvb.x = this.cva.x;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajT() {
        this.cvb.y = (int) (this.cuZ.y - (this.cvh * ((float) ajX())));
        if (this.cvb.y < this.cva.y) {
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajU() {
        this.cvb.x = (int) (this.cuZ.x - (this.cvg * ((float) ajX())));
        if (this.cvb.x < this.cva.x) {
            this.cvb.x = this.cva.x;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajV() {
        boolean z = true;
        this.cvb.x = (int) (this.cuZ.x - (this.cvg * ((float) ajX())));
        this.cvb.y = jO(this.cvb.x);
        if (this.cuZ.y <= this.cva.y ? this.cvb.y <= this.cva.y : this.cvb.y >= this.cva.y) {
            z = false;
        }
        if (this.cvb.x < this.cva.x || z) {
            this.cvb.x = this.cva.x;
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }

    private void ajW() {
        boolean z = true;
        this.cvb.x = (int) (this.cuZ.x + (this.cvg * ((float) ajX())));
        this.cvb.y = jO(this.cvb.x);
        if (this.cuZ.y <= this.cva.y ? this.cvb.y <= this.cva.y : this.cvb.y >= this.cva.y) {
            z = false;
        }
        if (this.cvb.x > this.cva.x || z) {
            this.cvb.x = this.cva.x;
            this.cvb.y = this.cva.y;
        }
        if (this.cve != null) {
            this.cve.a(this.cvb);
        }
    }
}
