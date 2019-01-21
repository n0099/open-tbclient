package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b hGX;
    private b hGY;

    public a(b bVar, b bVar2) {
        this.hGX = bVar;
        this.hGY = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return XR();
            case FIT_XY:
                return XK();
            case FIT_CENTER:
                return XM();
            case FIT_START:
                return XL();
            case FIT_END:
                return XN();
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
                return XO();
            case CENTER_INSIDE:
                return XP();
            case END_INSIDE:
                return XQ();
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
                return i(f, f2, 0.0f, this.hGX.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.hGX.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.hGX.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.hGX.getWidth() / 2.0f, this.hGX.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.hGX.getWidth() / 2.0f, this.hGX.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.hGX.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.hGX.getWidth(), this.hGX.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.hGX.getWidth(), this.hGX.getHeight());
            default:
                return null;
        }
    }

    private Matrix XR() {
        return a(this.hGY.getWidth() / this.hGX.getWidth(), this.hGY.getHeight() / this.hGX.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hGX.getWidth() / this.hGY.getWidth();
        float height = this.hGX.getHeight() / this.hGY.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix XK() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix XL() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix XM() {
        return a(PivotPoint.CENTER);
    }

    private Matrix XN() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hGY.getWidth() / this.hGX.getWidth(), this.hGY.getHeight() / this.hGX.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hGX.getWidth() / this.hGY.getWidth();
        float height = this.hGX.getHeight() / this.hGY.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix XO() {
        return (this.hGY.getHeight() > this.hGX.getWidth() || this.hGY.getHeight() > this.hGX.getHeight()) ? XL() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix XP() {
        return (this.hGY.getHeight() > this.hGX.getWidth() || this.hGY.getHeight() > this.hGX.getHeight()) ? XM() : b(PivotPoint.CENTER);
    }

    private Matrix XQ() {
        return (this.hGY.getHeight() > this.hGX.getWidth() || this.hGY.getHeight() > this.hGX.getHeight()) ? XN() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
