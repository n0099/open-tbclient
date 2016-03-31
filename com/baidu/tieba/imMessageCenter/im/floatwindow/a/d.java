package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a cug;
    private int cuh;
    private float cui;
    private float cuj;
    private final long cuk;
    private float k;
    private long startTime;
    private Point cub = new Point();
    private Point cud = new Point();
    private Point cuc = new Point();

    public d(long j) {
        this.cuk = j;
    }

    public void a(c.a aVar) {
        this.cug = aVar;
    }

    public void a(Point point, Point point2) {
        this.cub.x = point.x;
        this.cub.y = point.y;
        this.cud.x = point.x;
        this.cud.y = point.y;
        this.cuc.x = point2.x;
        this.cuc.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.cuj = Math.abs(point2.y - point.y) / ((float) this.cuk);
            if (point2.y > point.y) {
                this.cuh = 0;
            } else {
                this.cuh = 1;
            }
        } else if (point.y == point2.y) {
            this.cui = Math.abs(point2.x - point.x) / ((float) this.cuk);
            if (point2.x > point.x) {
                this.cuh = 2;
            } else {
                this.cuh = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.cui = Math.abs(f) / ((float) this.cuk);
            if (f > 0.0f) {
                this.cuh = 5;
            } else {
                this.cuh = 4;
            }
        }
    }

    private int kk(int i) {
        return (int) (((this.k * i) + this.cub.y) - (this.k * this.cub.x));
    }

    private long ajP() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.cud.equals(this.cuc)) {
            switch (this.cuh) {
                case 0:
                    ajJ();
                    break;
                case 1:
                    ajL();
                    break;
                case 2:
                    ajK();
                    break;
                case 3:
                    ajM();
                    break;
                case 4:
                    ajN();
                    break;
                case 5:
                    ajO();
                    break;
            }
            return false;
        }
        if (this.cug != null) {
            this.cug.ajC();
        }
        return true;
    }

    private void ajJ() {
        this.cud.y = (int) (this.cub.y + (this.cuj * ((float) ajP())));
        if (this.cud.y > this.cuc.y) {
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajK() {
        this.cud.x = (int) (this.cub.x + (this.cui * ((float) ajP())));
        if (this.cud.x > this.cuc.x) {
            this.cud.x = this.cuc.x;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajL() {
        this.cud.y = (int) (this.cub.y - (this.cuj * ((float) ajP())));
        if (this.cud.y < this.cuc.y) {
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajM() {
        this.cud.x = (int) (this.cub.x - (this.cui * ((float) ajP())));
        if (this.cud.x < this.cuc.x) {
            this.cud.x = this.cuc.x;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajN() {
        boolean z = true;
        this.cud.x = (int) (this.cub.x - (this.cui * ((float) ajP())));
        this.cud.y = kk(this.cud.x);
        if (this.cub.y <= this.cuc.y ? this.cud.y <= this.cuc.y : this.cud.y >= this.cuc.y) {
            z = false;
        }
        if (this.cud.x < this.cuc.x || z) {
            this.cud.x = this.cuc.x;
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajO() {
        boolean z = true;
        this.cud.x = (int) (this.cub.x + (this.cui * ((float) ajP())));
        this.cud.y = kk(this.cud.x);
        if (this.cub.y <= this.cuc.y ? this.cud.y <= this.cuc.y : this.cud.y >= this.cuc.y) {
            z = false;
        }
        if (this.cud.x > this.cuc.x || z) {
            this.cud.x = this.cuc.x;
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }
}
