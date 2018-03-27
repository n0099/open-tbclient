package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b hqZ;
    private b hra;

    public a(b bVar, b bVar2) {
        this.hqZ = bVar;
        this.hra = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return VO();
            case FIT_XY:
                return VH();
            case FIT_CENTER:
                return VJ();
            case FIT_START:
                return VI();
            case FIT_END:
                return VK();
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
                return VL();
            case CENTER_INSIDE:
                return VM();
            case END_INSIDE:
                return VN();
            default:
                return null;
        }
    }

    private Matrix j(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return j(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return j(f, f2, 0.0f, this.hqZ.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return j(f, f2, 0.0f, this.hqZ.getHeight());
            case CENTER_TOP:
                return j(f, f2, this.hqZ.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return j(f, f2, this.hqZ.getWidth() / 2.0f, this.hqZ.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return j(f, f2, this.hqZ.getWidth() / 2.0f, this.hqZ.getHeight());
            case RIGHT_TOP:
                return j(f, f2, this.hqZ.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return j(f, f2, this.hqZ.getWidth(), this.hqZ.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return j(f, f2, this.hqZ.getWidth(), this.hqZ.getHeight());
            default:
                return null;
        }
    }

    private Matrix VO() {
        return a(this.hra.getWidth() / this.hqZ.getWidth(), this.hra.getHeight() / this.hqZ.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hqZ.getWidth() / this.hra.getWidth();
        float height = this.hqZ.getHeight() / this.hra.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix VH() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix VI() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix VJ() {
        return a(PivotPoint.CENTER);
    }

    private Matrix VK() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hra.getWidth() / this.hqZ.getWidth(), this.hra.getHeight() / this.hqZ.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hqZ.getWidth() / this.hra.getWidth();
        float height = this.hqZ.getHeight() / this.hra.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix VL() {
        return (this.hra.getHeight() > this.hqZ.getWidth() || this.hra.getHeight() > this.hqZ.getHeight()) ? VI() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix VM() {
        return (this.hra.getHeight() > this.hqZ.getWidth() || this.hra.getHeight() > this.hqZ.getHeight()) ? VJ() : b(PivotPoint.CENTER);
    }

    private Matrix VN() {
        return (this.hra.getHeight() > this.hqZ.getWidth() || this.hra.getHeight() > this.hqZ.getHeight()) ? VK() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
