package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point cub;
    private Point cuc;
    private Point cud;
    private final int cue;
    private final int cuf;
    private a cug;
    private int cuh;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void ajC();
    }

    private int kk(int i) {
        return (int) (((this.k * i) + this.cub.y) - (this.k * this.cub.x));
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
        this.cud.y += this.cuf;
        if (this.cud.y > this.cuc.y) {
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajK() {
        this.cud.x += this.cue;
        if (this.cud.x > this.cuc.x) {
            this.cud.x = this.cuc.x;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajL() {
        this.cud.y -= this.cuf;
        if (this.cud.y < this.cuc.y) {
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajM() {
        this.cud.x -= this.cue;
        if (this.cud.x < this.cuc.x) {
            this.cud.x = this.cuc.x;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajN() {
        this.cud.x -= this.cue;
        this.cud.y = kk(this.cud.x);
        if (this.cud.x < this.cuc.x && this.cud.y < this.cuc.y) {
            this.cud.x = this.cuc.x;
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }

    private void ajO() {
        this.cud.x += this.cue;
        this.cud.y = kk(this.cud.x);
        if (this.cud.x > this.cuc.x && this.cud.y > this.cuc.y) {
            this.cud.x = this.cuc.x;
            this.cud.y = this.cuc.y;
        }
        if (this.cug != null) {
            this.cug.a(this.cud);
        }
    }
}
