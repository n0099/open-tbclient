package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a cfc;
    private int cfd;
    private float cfe;
    private float cff;
    private final long cfg;
    private float k;
    private long startTime;
    private Point ceX = new Point();
    private Point ceZ = new Point();
    private Point ceY = new Point();

    public d(long j) {
        this.cfg = j;
    }

    public void a(c.a aVar) {
        this.cfc = aVar;
    }

    public void a(Point point, Point point2) {
        this.ceX.x = point.x;
        this.ceX.y = point.y;
        this.ceZ.x = point.x;
        this.ceZ.y = point.y;
        this.ceY.x = point2.x;
        this.ceY.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.cff = Math.abs(point2.y - point.y) / ((float) this.cfg);
            if (point2.y > point.y) {
                this.cfd = 0;
            } else {
                this.cfd = 1;
            }
        } else if (point.y == point2.y) {
            this.cfe = Math.abs(point2.x - point.x) / ((float) this.cfg);
            if (point2.x > point.x) {
                this.cfd = 2;
            } else {
                this.cfd = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.cfe = Math.abs(f) / ((float) this.cfg);
            if (f > 0.0f) {
                this.cfd = 5;
            } else {
                this.cfd = 4;
            }
        }
    }

    private int jg(int i) {
        return (int) (((this.k * i) + this.ceX.y) - (this.k * this.ceX.x));
    }

    private long adm() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.ceZ.equals(this.ceY)) {
            switch (this.cfd) {
                case 0:
                    adg();
                    break;
                case 1:
                    adi();
                    break;
                case 2:
                    adh();
                    break;
                case 3:
                    adj();
                    break;
                case 4:
                    adk();
                    break;
                case 5:
                    adl();
                    break;
            }
            return false;
        }
        if (this.cfc != null) {
            this.cfc.acZ();
        }
        return true;
    }

    private void adg() {
        this.ceZ.y = (int) (this.ceX.y + (this.cff * ((float) adm())));
        if (this.ceZ.y > this.ceY.y) {
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adh() {
        this.ceZ.x = (int) (this.ceX.x + (this.cfe * ((float) adm())));
        if (this.ceZ.x > this.ceY.x) {
            this.ceZ.x = this.ceY.x;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adi() {
        this.ceZ.y = (int) (this.ceX.y - (this.cff * ((float) adm())));
        if (this.ceZ.y < this.ceY.y) {
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adj() {
        this.ceZ.x = (int) (this.ceX.x - (this.cfe * ((float) adm())));
        if (this.ceZ.x < this.ceY.x) {
            this.ceZ.x = this.ceY.x;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adk() {
        boolean z = true;
        this.ceZ.x = (int) (this.ceX.x - (this.cfe * ((float) adm())));
        this.ceZ.y = jg(this.ceZ.x);
        if (this.ceX.y <= this.ceY.y ? this.ceZ.y <= this.ceY.y : this.ceZ.y >= this.ceY.y) {
            z = false;
        }
        if (this.ceZ.x < this.ceY.x || z) {
            this.ceZ.x = this.ceY.x;
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adl() {
        boolean z = true;
        this.ceZ.x = (int) (this.ceX.x + (this.cfe * ((float) adm())));
        this.ceZ.y = jg(this.ceZ.x);
        if (this.ceX.y <= this.ceY.y ? this.ceZ.y <= this.ceY.y : this.ceZ.y >= this.ceY.y) {
            z = false;
        }
        if (this.ceZ.x > this.ceY.x || z) {
            this.ceZ.x = this.ceY.x;
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }
}
