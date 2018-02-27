package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b hqB;
    private b hqC;

    public a(b bVar, b bVar2) {
        this.hqB = bVar;
        this.hqC = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return VN();
            case FIT_XY:
                return VG();
            case FIT_CENTER:
                return VI();
            case FIT_START:
                return VH();
            case FIT_END:
                return VJ();
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
                return VK();
            case CENTER_INSIDE:
                return VL();
            case END_INSIDE:
                return VM();
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
                return j(f, f2, 0.0f, this.hqB.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return j(f, f2, 0.0f, this.hqB.getHeight());
            case CENTER_TOP:
                return j(f, f2, this.hqB.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return j(f, f2, this.hqB.getWidth() / 2.0f, this.hqB.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return j(f, f2, this.hqB.getWidth() / 2.0f, this.hqB.getHeight());
            case RIGHT_TOP:
                return j(f, f2, this.hqB.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return j(f, f2, this.hqB.getWidth(), this.hqB.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return j(f, f2, this.hqB.getWidth(), this.hqB.getHeight());
            default:
                return null;
        }
    }

    private Matrix VN() {
        return a(this.hqC.getWidth() / this.hqB.getWidth(), this.hqC.getHeight() / this.hqB.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hqB.getWidth() / this.hqC.getWidth();
        float height = this.hqB.getHeight() / this.hqC.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix VG() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix VH() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix VI() {
        return a(PivotPoint.CENTER);
    }

    private Matrix VJ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hqC.getWidth() / this.hqB.getWidth(), this.hqC.getHeight() / this.hqB.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hqB.getWidth() / this.hqC.getWidth();
        float height = this.hqB.getHeight() / this.hqC.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix VK() {
        return (this.hqC.getHeight() > this.hqB.getWidth() || this.hqC.getHeight() > this.hqB.getHeight()) ? VH() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix VL() {
        return (this.hqC.getHeight() > this.hqB.getWidth() || this.hqC.getHeight() > this.hqB.getHeight()) ? VI() : b(PivotPoint.CENTER);
    }

    private Matrix VM() {
        return (this.hqC.getHeight() > this.hqB.getWidth() || this.hqC.getHeight() > this.hqB.getHeight()) ? VJ() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
