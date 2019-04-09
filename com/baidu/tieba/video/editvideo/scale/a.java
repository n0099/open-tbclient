package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b iXn;
    private b iXo;

    public a(b bVar, b bVar2) {
        this.iXn = bVar;
        this.iXo = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return axN();
            case FIT_XY:
                return axG();
            case FIT_CENTER:
                return axI();
            case FIT_START:
                return axH();
            case FIT_END:
                return axJ();
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
                return axK();
            case CENTER_INSIDE:
                return axL();
            case END_INSIDE:
                return axM();
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
                return i(f, f2, 0.0f, this.iXn.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.iXn.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.iXn.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.iXn.getWidth() / 2.0f, this.iXn.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.iXn.getWidth() / 2.0f, this.iXn.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.iXn.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.iXn.getWidth(), this.iXn.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.iXn.getWidth(), this.iXn.getHeight());
            default:
                return null;
        }
    }

    private Matrix axN() {
        return a(this.iXo.getWidth() / this.iXn.getWidth(), this.iXo.getHeight() / this.iXn.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.iXn.getWidth() / this.iXo.getWidth();
        float height = this.iXn.getHeight() / this.iXo.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix axG() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix axH() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix axI() {
        return a(PivotPoint.CENTER);
    }

    private Matrix axJ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.iXo.getWidth() / this.iXn.getWidth(), this.iXo.getHeight() / this.iXn.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.iXn.getWidth() / this.iXo.getWidth();
        float height = this.iXn.getHeight() / this.iXo.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix axK() {
        return (this.iXo.getHeight() > this.iXn.getWidth() || this.iXo.getHeight() > this.iXn.getHeight()) ? axH() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix axL() {
        return (this.iXo.getHeight() > this.iXn.getWidth() || this.iXo.getHeight() > this.iXn.getHeight()) ? axI() : b(PivotPoint.CENTER);
    }

    private Matrix axM() {
        return (this.iXo.getHeight() > this.iXn.getWidth() || this.iXo.getHeight() > this.iXn.getHeight()) ? axJ() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
