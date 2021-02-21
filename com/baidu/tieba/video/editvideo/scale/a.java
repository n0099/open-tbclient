package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b nNA;
    private b nNz;

    public a(b bVar, b bVar2) {
        this.nNz = bVar;
        this.nNA = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bMX();
            case FIT_XY:
                return bMQ();
            case FIT_CENTER:
                return bMS();
            case FIT_START:
                return bMR();
            case FIT_END:
                return bMT();
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
                return bMU();
            case CENTER_INSIDE:
                return bMV();
            case END_INSIDE:
                return bMW();
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
                return e(f, f2, 0.0f, this.nNz.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nNz.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nNz.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nNz.getWidth() / 2.0f, this.nNz.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nNz.getWidth() / 2.0f, this.nNz.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nNz.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nNz.getWidth(), this.nNz.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nNz.getWidth(), this.nNz.getHeight());
            default:
                return null;
        }
    }

    private Matrix bMX() {
        return a(this.nNA.getWidth() / this.nNz.getWidth(), this.nNA.getHeight() / this.nNz.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nNz.getWidth() / this.nNA.getWidth();
        float height = this.nNz.getHeight() / this.nNA.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bMQ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bMR() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bMS() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bMT() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nNA.getWidth() / this.nNz.getWidth(), this.nNA.getHeight() / this.nNz.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nNz.getWidth() / this.nNA.getWidth();
        float height = this.nNz.getHeight() / this.nNA.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bMU() {
        return (this.nNA.getHeight() > this.nNz.getWidth() || this.nNA.getHeight() > this.nNz.getHeight()) ? bMR() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bMV() {
        return (this.nNA.getHeight() > this.nNz.getWidth() || this.nNA.getHeight() > this.nNz.getHeight()) ? bMS() : b(PivotPoint.CENTER);
    }

    private Matrix bMW() {
        return (this.nNA.getHeight() > this.nNz.getWidth() || this.nNA.getHeight() > this.nNz.getHeight()) ? bMT() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
