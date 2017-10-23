package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gvx;
    private b gvy;

    public a(b bVar, b bVar2) {
        this.gvx = bVar;
        this.gvy = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return MI();
            case FIT_XY:
                return MB();
            case FIT_CENTER:
                return MD();
            case FIT_START:
                return MC();
            case FIT_END:
                return ME();
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
                return MF();
            case CENTER_INSIDE:
                return MG();
            case END_INSIDE:
                return MH();
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
                return f(f, f2, 0.0f, this.gvx.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return f(f, f2, 0.0f, this.gvx.getHeight());
            case CENTER_TOP:
                return f(f, f2, this.gvx.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return f(f, f2, this.gvx.getWidth() / 2.0f, this.gvx.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return f(f, f2, this.gvx.getWidth() / 2.0f, this.gvx.getHeight());
            case RIGHT_TOP:
                return f(f, f2, this.gvx.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return f(f, f2, this.gvx.getWidth(), this.gvx.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return f(f, f2, this.gvx.getWidth(), this.gvx.getHeight());
            default:
                return null;
        }
    }

    private Matrix MI() {
        return a(this.gvy.getWidth() / this.gvx.getWidth(), this.gvy.getHeight() / this.gvx.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gvx.getWidth() / this.gvy.getWidth();
        float height = this.gvx.getHeight() / this.gvy.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix MB() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix MC() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix MD() {
        return a(PivotPoint.CENTER);
    }

    private Matrix ME() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gvy.getWidth() / this.gvx.getWidth(), this.gvy.getHeight() / this.gvx.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gvx.getWidth() / this.gvy.getWidth();
        float height = this.gvx.getHeight() / this.gvy.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix MF() {
        return (this.gvy.getHeight() > this.gvx.getWidth() || this.gvy.getHeight() > this.gvx.getHeight()) ? MC() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix MG() {
        return (this.gvy.getHeight() > this.gvx.getWidth() || this.gvy.getHeight() > this.gvx.getHeight()) ? MD() : b(PivotPoint.CENTER);
    }

    private Matrix MH() {
        return (this.gvy.getHeight() > this.gvx.getWidth() || this.gvy.getHeight() > this.gvx.getHeight()) ? ME() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
