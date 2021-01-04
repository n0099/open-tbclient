package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b nHU;
    private b nHV;

    public a(b bVar, b bVar2) {
        this.nHU = bVar;
        this.nHV = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bQg();
            case FIT_XY:
                return bPZ();
            case FIT_CENTER:
                return bQb();
            case FIT_START:
                return bQa();
            case FIT_END:
                return bQc();
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
                return bQd();
            case CENTER_INSIDE:
                return bQe();
            case END_INSIDE:
                return bQf();
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
                return e(f, f2, 0.0f, this.nHU.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nHU.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nHU.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nHU.getWidth() / 2.0f, this.nHU.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nHU.getWidth() / 2.0f, this.nHU.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nHU.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nHU.getWidth(), this.nHU.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nHU.getWidth(), this.nHU.getHeight());
            default:
                return null;
        }
    }

    private Matrix bQg() {
        return a(this.nHV.getWidth() / this.nHU.getWidth(), this.nHV.getHeight() / this.nHU.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nHU.getWidth() / this.nHV.getWidth();
        float height = this.nHU.getHeight() / this.nHV.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bPZ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bQa() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bQb() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bQc() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nHV.getWidth() / this.nHU.getWidth(), this.nHV.getHeight() / this.nHU.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nHU.getWidth() / this.nHV.getWidth();
        float height = this.nHU.getHeight() / this.nHV.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bQd() {
        return (this.nHV.getHeight() > this.nHU.getWidth() || this.nHV.getHeight() > this.nHU.getHeight()) ? bQa() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bQe() {
        return (this.nHV.getHeight() > this.nHU.getWidth() || this.nHV.getHeight() > this.nHU.getHeight()) ? bQb() : b(PivotPoint.CENTER);
    }

    private Matrix bQf() {
        return (this.nHV.getHeight() > this.nHU.getWidth() || this.nHV.getHeight() > this.nHU.getHeight()) ? bQc() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
