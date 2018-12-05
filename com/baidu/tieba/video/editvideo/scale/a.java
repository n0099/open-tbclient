package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b hCE;
    private b hCF;

    public a(b bVar, b bVar2) {
        this.hCE = bVar;
        this.hCF = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Xs();
            case FIT_XY:
                return Xl();
            case FIT_CENTER:
                return Xn();
            case FIT_START:
                return Xm();
            case FIT_END:
                return Xo();
            case LEFT_TOP:
                return b(PivotPoint.LEFT_TOP);
            case LEFT_CENTER:
                return b(PivotPoint.LEFT_CENTER);
            case LEFT_BOTTOM:
                return b(PivotPoint.LEFT_BOTTOM);
            case CENTER_TOP:
                return b(PivotPoint.CENTER_TOP);
            case CENTER:
                return b(PivotPoint.CENTER);
            case CENTER_BOTTOM:
                return b(PivotPoint.CENTER_BOTTOM);
            case RIGHT_TOP:
                return b(PivotPoint.RIGHT_TOP);
            case RIGHT_CENTER:
                return b(PivotPoint.RIGHT_CENTER);
            case RIGHT_BOTTOM:
                return b(PivotPoint.RIGHT_BOTTOM);
            case LEFT_TOP_CROP:
                return c(PivotPoint.LEFT_TOP);
            case LEFT_CENTER_CROP:
                return c(PivotPoint.LEFT_CENTER);
            case LEFT_BOTTOM_CROP:
                return c(PivotPoint.LEFT_BOTTOM);
            case CENTER_TOP_CROP:
                return c(PivotPoint.CENTER_TOP);
            case CENTER_CROP:
                return c(PivotPoint.CENTER);
            case CENTER_BOTTOM_CROP:
                return c(PivotPoint.CENTER_BOTTOM);
            case RIGHT_TOP_CROP:
                return c(PivotPoint.RIGHT_TOP);
            case RIGHT_CENTER_CROP:
                return c(PivotPoint.RIGHT_CENTER);
            case RIGHT_BOTTOM_CROP:
                return c(PivotPoint.RIGHT_BOTTOM);
            case START_INSIDE:
                return Xp();
            case CENTER_INSIDE:
                return Xq();
            case END_INSIDE:
                return Xr();
            default:
                return null;
        }
    }

    private Matrix i(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return i(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return i(f, f2, 0.0f, this.hCE.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.hCE.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.hCE.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.hCE.getWidth() / 2.0f, this.hCE.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.hCE.getWidth() / 2.0f, this.hCE.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.hCE.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.hCE.getWidth(), this.hCE.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.hCE.getWidth(), this.hCE.getHeight());
            default:
                return null;
        }
    }

    private Matrix Xs() {
        return a(this.hCF.getWidth() / this.hCE.getWidth(), this.hCF.getHeight() / this.hCE.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hCE.getWidth() / this.hCF.getWidth();
        float height = this.hCE.getHeight() / this.hCF.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Xl() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Xm() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Xn() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Xo() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hCF.getWidth() / this.hCE.getWidth(), this.hCF.getHeight() / this.hCE.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hCE.getWidth() / this.hCF.getWidth();
        float height = this.hCE.getHeight() / this.hCF.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Xp() {
        return (this.hCF.getHeight() > this.hCE.getWidth() || this.hCF.getHeight() > this.hCE.getHeight()) ? Xm() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Xq() {
        return (this.hCF.getHeight() > this.hCE.getWidth() || this.hCF.getHeight() > this.hCE.getHeight()) ? Xn() : b(PivotPoint.CENTER);
    }

    private Matrix Xr() {
        return (this.hCF.getHeight() > this.hCE.getWidth() || this.hCF.getHeight() > this.hCE.getHeight()) ? Xo() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
