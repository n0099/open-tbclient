package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b lDC;
    private b lDD;

    public a(b bVar, b bVar2) {
        this.lDC = bVar;
        this.lDD = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bnW();
            case FIT_XY:
                return bnP();
            case FIT_CENTER:
                return bnR();
            case FIT_START:
                return bnQ();
            case FIT_END:
                return bnS();
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
                return bnT();
            case CENTER_INSIDE:
                return bnU();
            case END_INSIDE:
                return bnV();
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
                return e(f, f2, 0.0f, this.lDC.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.lDC.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.lDC.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.lDC.getWidth() / 2.0f, this.lDC.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.lDC.getWidth() / 2.0f, this.lDC.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.lDC.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.lDC.getWidth(), this.lDC.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.lDC.getWidth(), this.lDC.getHeight());
            default:
                return null;
        }
    }

    private Matrix bnW() {
        return a(this.lDD.getWidth() / this.lDC.getWidth(), this.lDD.getHeight() / this.lDC.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.lDC.getWidth() / this.lDD.getWidth();
        float height = this.lDC.getHeight() / this.lDD.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bnP() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bnQ() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bnR() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bnS() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.lDD.getWidth() / this.lDC.getWidth(), this.lDD.getHeight() / this.lDC.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.lDC.getWidth() / this.lDD.getWidth();
        float height = this.lDC.getHeight() / this.lDD.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bnT() {
        return (this.lDD.getHeight() > this.lDC.getWidth() || this.lDD.getHeight() > this.lDC.getHeight()) ? bnQ() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bnU() {
        return (this.lDD.getHeight() > this.lDC.getWidth() || this.lDD.getHeight() > this.lDC.getHeight()) ? bnR() : b(PivotPoint.CENTER);
    }

    private Matrix bnV() {
        return (this.lDD.getHeight() > this.lDC.getWidth() || this.lDD.getHeight() > this.lDC.getHeight()) ? bnS() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
