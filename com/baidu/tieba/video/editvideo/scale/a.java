package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b nMZ;
    private b nNa;

    public a(b bVar, b bVar2) {
        this.nMZ = bVar;
        this.nNa = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bMQ();
            case FIT_XY:
                return bMJ();
            case FIT_CENTER:
                return bML();
            case FIT_START:
                return bMK();
            case FIT_END:
                return bMM();
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
                return bMN();
            case CENTER_INSIDE:
                return bMO();
            case END_INSIDE:
                return bMP();
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
                return e(f, f2, 0.0f, this.nMZ.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nMZ.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nMZ.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nMZ.getWidth() / 2.0f, this.nMZ.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nMZ.getWidth() / 2.0f, this.nMZ.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nMZ.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nMZ.getWidth(), this.nMZ.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nMZ.getWidth(), this.nMZ.getHeight());
            default:
                return null;
        }
    }

    private Matrix bMQ() {
        return a(this.nNa.getWidth() / this.nMZ.getWidth(), this.nNa.getHeight() / this.nMZ.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nMZ.getWidth() / this.nNa.getWidth();
        float height = this.nMZ.getHeight() / this.nNa.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bMJ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bMK() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bML() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bMM() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nNa.getWidth() / this.nMZ.getWidth(), this.nNa.getHeight() / this.nMZ.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nMZ.getWidth() / this.nNa.getWidth();
        float height = this.nMZ.getHeight() / this.nNa.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bMN() {
        return (this.nNa.getHeight() > this.nMZ.getWidth() || this.nNa.getHeight() > this.nMZ.getHeight()) ? bMK() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bMO() {
        return (this.nNa.getHeight() > this.nMZ.getWidth() || this.nNa.getHeight() > this.nMZ.getHeight()) ? bML() : b(PivotPoint.CENTER);
    }

    private Matrix bMP() {
        return (this.nNa.getHeight() > this.nMZ.getWidth() || this.nNa.getHeight() > this.nMZ.getHeight()) ? bMM() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
