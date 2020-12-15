package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b nDP;
    private b nDQ;

    public a(b bVar, b bVar2) {
        this.nDP = bVar;
        this.nDQ = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bNN();
            case FIT_XY:
                return bNG();
            case FIT_CENTER:
                return bNI();
            case FIT_START:
                return bNH();
            case FIT_END:
                return bNJ();
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
                return bNK();
            case CENTER_INSIDE:
                return bNL();
            case END_INSIDE:
                return bNM();
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
                return e(f, f2, 0.0f, this.nDP.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nDP.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nDP.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nDP.getWidth() / 2.0f, this.nDP.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nDP.getWidth() / 2.0f, this.nDP.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nDP.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nDP.getWidth(), this.nDP.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nDP.getWidth(), this.nDP.getHeight());
            default:
                return null;
        }
    }

    private Matrix bNN() {
        return a(this.nDQ.getWidth() / this.nDP.getWidth(), this.nDQ.getHeight() / this.nDP.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nDP.getWidth() / this.nDQ.getWidth();
        float height = this.nDP.getHeight() / this.nDQ.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bNG() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bNH() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bNI() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bNJ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nDQ.getWidth() / this.nDP.getWidth(), this.nDQ.getHeight() / this.nDP.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nDP.getWidth() / this.nDQ.getWidth();
        float height = this.nDP.getHeight() / this.nDQ.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bNK() {
        return (this.nDQ.getHeight() > this.nDP.getWidth() || this.nDQ.getHeight() > this.nDP.getHeight()) ? bNH() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bNL() {
        return (this.nDQ.getHeight() > this.nDP.getWidth() || this.nDQ.getHeight() > this.nDP.getHeight()) ? bNI() : b(PivotPoint.CENTER);
    }

    private Matrix bNM() {
        return (this.nDQ.getHeight() > this.nDP.getWidth() || this.nDQ.getHeight() > this.nDP.getHeight()) ? bNJ() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
