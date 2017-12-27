package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b hzC;
    private b hzD;

    public a(b bVar, b bVar2) {
        this.hzC = bVar;
        this.hzD = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Vg();
            case FIT_XY:
                return UZ();
            case FIT_CENTER:
                return Vb();
            case FIT_START:
                return Va();
            case FIT_END:
                return Vc();
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
                return Vd();
            case CENTER_INSIDE:
                return Ve();
            case END_INSIDE:
                return Vf();
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
                return i(f, f2, 0.0f, this.hzC.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.hzC.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.hzC.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.hzC.getWidth() / 2.0f, this.hzC.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.hzC.getWidth() / 2.0f, this.hzC.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.hzC.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.hzC.getWidth(), this.hzC.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.hzC.getWidth(), this.hzC.getHeight());
            default:
                return null;
        }
    }

    private Matrix Vg() {
        return a(this.hzD.getWidth() / this.hzC.getWidth(), this.hzD.getHeight() / this.hzC.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hzC.getWidth() / this.hzD.getWidth();
        float height = this.hzC.getHeight() / this.hzD.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix UZ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Va() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Vb() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Vc() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hzD.getWidth() / this.hzC.getWidth(), this.hzD.getHeight() / this.hzC.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hzC.getWidth() / this.hzD.getWidth();
        float height = this.hzC.getHeight() / this.hzD.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Vd() {
        return (this.hzD.getHeight() > this.hzC.getWidth() || this.hzD.getHeight() > this.hzC.getHeight()) ? Va() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Ve() {
        return (this.hzD.getHeight() > this.hzC.getWidth() || this.hzD.getHeight() > this.hzC.getHeight()) ? Vb() : b(PivotPoint.CENTER);
    }

    private Matrix Vf() {
        return (this.hzD.getHeight() > this.hzC.getWidth() || this.hzD.getHeight() > this.hzC.getHeight()) ? Vc() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
