package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e bqN;
    private int bqO;
    private float bqP;
    private float bqQ;
    private final long bqR;
    private float k;
    private long startTime;
    private Point bqI = new Point();
    private Point bqK = new Point();
    private Point bqJ = new Point();

    public f(long j) {
        this.bqR = j;
    }

    public void a(e eVar) {
        this.bqN = eVar;
    }

    public void a(Point point, Point point2) {
        this.bqI.x = point.x;
        this.bqI.y = point.y;
        this.bqK.x = point.x;
        this.bqK.y = point.y;
        this.bqJ.x = point2.x;
        this.bqJ.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.bqQ = Math.abs(point2.y - point.y) / ((float) this.bqR);
            if (point2.y > point.y) {
                this.bqO = 0;
            } else {
                this.bqO = 1;
            }
        } else if (point.y == point2.y) {
            this.bqP = Math.abs(point2.x - point.x) / ((float) this.bqR);
            if (point2.x > point.x) {
                this.bqO = 2;
            } else {
                this.bqO = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.bqP = Math.abs(f) / ((float) this.bqR);
            if (f > 0.0f) {
                this.bqO = 5;
            } else {
                this.bqO = 4;
            }
        }
    }

    private int gt(int i) {
        return (int) (((this.k * i) + this.bqI.y) - (this.k * this.bqI.x));
    }

    private long UK() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.bqK.equals(this.bqJ)) {
            switch (this.bqO) {
                case 0:
                    UE();
                    break;
                case 1:
                    UG();
                    break;
                case 2:
                    UF();
                    break;
                case 3:
                    UH();
                    break;
                case 4:
                    UI();
                    break;
                case 5:
                    UJ();
                    break;
            }
            return false;
        }
        if (this.bqN != null) {
            this.bqN.Ux();
        }
        return true;
    }

    private void UE() {
        this.bqK.y = (int) (this.bqI.y + (this.bqQ * ((float) UK())));
        if (this.bqK.y > this.bqJ.y) {
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UF() {
        this.bqK.x = (int) (this.bqI.x + (this.bqP * ((float) UK())));
        if (this.bqK.x > this.bqJ.x) {
            this.bqK.x = this.bqJ.x;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UG() {
        this.bqK.y = (int) (this.bqI.y - (this.bqQ * ((float) UK())));
        if (this.bqK.y < this.bqJ.y) {
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UH() {
        this.bqK.x = (int) (this.bqI.x - (this.bqP * ((float) UK())));
        if (this.bqK.x < this.bqJ.x) {
            this.bqK.x = this.bqJ.x;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UI() {
        boolean z = true;
        this.bqK.x = (int) (this.bqI.x - (this.bqP * ((float) UK())));
        this.bqK.y = gt(this.bqK.x);
        if (this.bqI.y <= this.bqJ.y ? this.bqK.y <= this.bqJ.y : this.bqK.y >= this.bqJ.y) {
            z = false;
        }
        if (this.bqK.x < this.bqJ.x || z) {
            this.bqK.x = this.bqJ.x;
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }

    private void UJ() {
        boolean z = true;
        this.bqK.x = (int) (this.bqI.x + (this.bqP * ((float) UK())));
        this.bqK.y = gt(this.bqK.x);
        if (this.bqI.y <= this.bqJ.y ? this.bqK.y <= this.bqJ.y : this.bqK.y >= this.bqJ.y) {
            z = false;
        }
        if (this.bqK.x > this.bqJ.x || z) {
            this.bqK.x = this.bqJ.x;
            this.bqK.y = this.bqJ.y;
        }
        if (this.bqN != null) {
            this.bqN.a(this.bqK);
        }
    }
}
