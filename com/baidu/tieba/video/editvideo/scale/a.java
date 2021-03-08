package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes7.dex */
public class a {
    private b nPE;
    private b nPF;

    public a(b bVar, b bVar2) {
        this.nPE = bVar;
        this.nPF = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bNd();
            case FIT_XY:
                return bMW();
            case FIT_CENTER:
                return bMY();
            case FIT_START:
                return bMX();
            case FIT_END:
                return bMZ();
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
                return bNa();
            case CENTER_INSIDE:
                return bNb();
            case END_INSIDE:
                return bNc();
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
                return e(f, f2, 0.0f, this.nPE.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nPE.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nPE.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nPE.getWidth() / 2.0f, this.nPE.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nPE.getWidth() / 2.0f, this.nPE.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nPE.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nPE.getWidth(), this.nPE.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nPE.getWidth(), this.nPE.getHeight());
            default:
                return null;
        }
    }

    private Matrix bNd() {
        return a(this.nPF.getWidth() / this.nPE.getWidth(), this.nPF.getHeight() / this.nPE.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nPE.getWidth() / this.nPF.getWidth();
        float height = this.nPE.getHeight() / this.nPF.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bMW() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bMX() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bMY() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bMZ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nPF.getWidth() / this.nPE.getWidth(), this.nPF.getHeight() / this.nPE.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nPE.getWidth() / this.nPF.getWidth();
        float height = this.nPE.getHeight() / this.nPF.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bNa() {
        return (this.nPF.getHeight() > this.nPE.getWidth() || this.nPF.getHeight() > this.nPE.getHeight()) ? bMX() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bNb() {
        return (this.nPF.getHeight() > this.nPE.getWidth() || this.nPF.getHeight() > this.nPE.getHeight()) ? bMY() : b(PivotPoint.CENTER);
    }

    private Matrix bNc() {
        return (this.nPF.getHeight() > this.nPE.getWidth() || this.nPF.getHeight() > this.nPE.getHeight()) ? bMZ() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
