package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gvM;
    private b gvN;

    public a(b bVar, b bVar2) {
        this.gvM = bVar;
        this.gvN = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return MO();
            case FIT_XY:
                return MH();
            case FIT_CENTER:
                return MJ();
            case FIT_START:
                return MI();
            case FIT_END:
                return MK();
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
                return ML();
            case CENTER_INSIDE:
                return MM();
            case END_INSIDE:
                return MN();
            default:
                return null;
        }
    }

    private Matrix f(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return f(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return f(f, f2, 0.0f, this.gvM.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return f(f, f2, 0.0f, this.gvM.getHeight());
            case CENTER_TOP:
                return f(f, f2, this.gvM.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return f(f, f2, this.gvM.getWidth() / 2.0f, this.gvM.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return f(f, f2, this.gvM.getWidth() / 2.0f, this.gvM.getHeight());
            case RIGHT_TOP:
                return f(f, f2, this.gvM.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return f(f, f2, this.gvM.getWidth(), this.gvM.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return f(f, f2, this.gvM.getWidth(), this.gvM.getHeight());
            default:
                return null;
        }
    }

    private Matrix MO() {
        return a(this.gvN.getWidth() / this.gvM.getWidth(), this.gvN.getHeight() / this.gvM.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gvM.getWidth() / this.gvN.getWidth();
        float height = this.gvM.getHeight() / this.gvN.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix MH() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix MI() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix MJ() {
        return a(PivotPoint.CENTER);
    }

    private Matrix MK() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gvN.getWidth() / this.gvM.getWidth(), this.gvN.getHeight() / this.gvM.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gvM.getWidth() / this.gvN.getWidth();
        float height = this.gvM.getHeight() / this.gvN.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix ML() {
        return (this.gvN.getHeight() > this.gvM.getWidth() || this.gvN.getHeight() > this.gvM.getHeight()) ? MI() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix MM() {
        return (this.gvN.getHeight() > this.gvM.getWidth() || this.gvN.getHeight() > this.gvM.getHeight()) ? MJ() : b(PivotPoint.CENTER);
    }

    private Matrix MN() {
        return (this.gvN.getHeight() > this.gvM.getWidth() || this.gvN.getHeight() > this.gvM.getHeight()) ? MK() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
