package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a dwe;
    private int dwf;
    private float dwg;
    private float dwh;
    private final long dwi;
    private float k;
    private long startTime;
    private Point dvZ = new Point();
    private Point dwb = new Point();
    private Point dwa = new Point();

    public d(long j) {
        this.dwi = j;
    }

    public void a(c.a aVar) {
        this.dwe = aVar;
    }

    public void a(Point point, Point point2) {
        this.dvZ.x = point.x;
        this.dvZ.y = point.y;
        this.dwb.x = point.x;
        this.dwb.y = point.y;
        this.dwa.x = point2.x;
        this.dwa.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.dwh = Math.abs(point2.y - point.y) / ((float) this.dwi);
            if (point2.y > point.y) {
                this.dwf = 0;
            } else {
                this.dwf = 1;
            }
        } else if (point.y == point2.y) {
            this.dwg = Math.abs(point2.x - point.x) / ((float) this.dwi);
            if (point2.x > point.x) {
                this.dwf = 2;
            } else {
                this.dwf = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.dwg = Math.abs(f) / ((float) this.dwi);
            if (f > 0.0f) {
                this.dwf = 5;
            } else {
                this.dwf = 4;
            }
        }
    }

    private int mp(int i) {
        return (int) (((this.k * i) + this.dvZ.y) - (this.k * this.dvZ.x));
    }

    private long Ui() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.dwb.equals(this.dwa)) {
            switch (this.dwf) {
                case 0:
                    aAb();
                    break;
                case 1:
                    aAd();
                    break;
                case 2:
                    aAc();
                    break;
                case 3:
                    aAe();
                    break;
                case 4:
                    aAf();
                    break;
                case 5:
                    aAg();
                    break;
            }
            return false;
        }
        if (this.dwe != null) {
            this.dwe.azU();
        }
        return true;
    }

    private void aAb() {
        this.dwb.y = (int) (this.dvZ.y + (this.dwh * ((float) Ui())));
        if (this.dwb.y > this.dwa.y) {
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAc() {
        this.dwb.x = (int) (this.dvZ.x + (this.dwg * ((float) Ui())));
        if (this.dwb.x > this.dwa.x) {
            this.dwb.x = this.dwa.x;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAd() {
        this.dwb.y = (int) (this.dvZ.y - (this.dwh * ((float) Ui())));
        if (this.dwb.y < this.dwa.y) {
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAe() {
        this.dwb.x = (int) (this.dvZ.x - (this.dwg * ((float) Ui())));
        if (this.dwb.x < this.dwa.x) {
            this.dwb.x = this.dwa.x;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAf() {
        boolean z = true;
        this.dwb.x = (int) (this.dvZ.x - (this.dwg * ((float) Ui())));
        this.dwb.y = mp(this.dwb.x);
        if (this.dvZ.y <= this.dwa.y ? this.dwb.y <= this.dwa.y : this.dwb.y >= this.dwa.y) {
            z = false;
        }
        if (this.dwb.x < this.dwa.x || z) {
            this.dwb.x = this.dwa.x;
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAg() {
        boolean z = true;
        this.dwb.x = (int) (this.dvZ.x + (this.dwg * ((float) Ui())));
        this.dwb.y = mp(this.dwb.x);
        if (this.dvZ.y <= this.dwa.y ? this.dwb.y <= this.dwa.y : this.dwb.y >= this.dwa.y) {
            z = false;
        }
        if (this.dwb.x > this.dwa.x || z) {
            this.dwb.x = this.dwa.x;
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }
}
