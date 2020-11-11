package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b noF;
    private b noG;

    public a(b bVar, b bVar2) {
        this.noF = bVar;
        this.noG = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bKL();
            case FIT_XY:
                return bKE();
            case FIT_CENTER:
                return bKG();
            case FIT_START:
                return bKF();
            case FIT_END:
                return bKH();
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
                return bKI();
            case CENTER_INSIDE:
                return bKJ();
            case END_INSIDE:
                return bKK();
            default:
                return null;
        }
    }

    private Matrix e(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.noF.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.noF.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.noF.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.noF.getWidth() / 2.0f, this.noF.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.noF.getWidth() / 2.0f, this.noF.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.noF.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.noF.getWidth(), this.noF.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.noF.getWidth(), this.noF.getHeight());
            default:
                return null;
        }
    }

    private Matrix bKL() {
        return a(this.noG.getWidth() / this.noF.getWidth(), this.noG.getHeight() / this.noF.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.noF.getWidth() / this.noG.getWidth();
        float height = this.noF.getHeight() / this.noG.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bKE() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bKF() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bKG() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bKH() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.noG.getWidth() / this.noF.getWidth(), this.noG.getHeight() / this.noF.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.noF.getWidth() / this.noG.getWidth();
        float height = this.noF.getHeight() / this.noG.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bKI() {
        return (this.noG.getHeight() > this.noF.getWidth() || this.noG.getHeight() > this.noF.getHeight()) ? bKF() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bKJ() {
        return (this.noG.getHeight() > this.noF.getWidth() || this.noG.getHeight() > this.noF.getHeight()) ? bKG() : b(PivotPoint.CENTER);
    }

    private Matrix bKK() {
        return (this.noG.getHeight() > this.noF.getWidth() || this.noG.getHeight() > this.noF.getHeight()) ? bKH() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
