package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes17.dex */
public class a {
    private b meF;
    private b meG;

    public a(b bVar, b bVar2) {
        this.meF = bVar;
        this.meG = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return btz();
            case FIT_XY:
                return bts();
            case FIT_CENTER:
                return btu();
            case FIT_START:
                return btt();
            case FIT_END:
                return btv();
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
                return btw();
            case CENTER_INSIDE:
                return btx();
            case END_INSIDE:
                return bty();
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
                return e(f, f2, 0.0f, this.meF.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.meF.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.meF.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.meF.getWidth() / 2.0f, this.meF.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.meF.getWidth() / 2.0f, this.meF.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.meF.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.meF.getWidth(), this.meF.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.meF.getWidth(), this.meF.getHeight());
            default:
                return null;
        }
    }

    private Matrix btz() {
        return a(this.meG.getWidth() / this.meF.getWidth(), this.meG.getHeight() / this.meF.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.meF.getWidth() / this.meG.getWidth();
        float height = this.meF.getHeight() / this.meG.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bts() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix btt() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix btu() {
        return a(PivotPoint.CENTER);
    }

    private Matrix btv() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.meG.getWidth() / this.meF.getWidth(), this.meG.getHeight() / this.meF.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.meF.getWidth() / this.meG.getWidth();
        float height = this.meF.getHeight() / this.meG.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix btw() {
        return (this.meG.getHeight() > this.meF.getWidth() || this.meG.getHeight() > this.meF.getHeight()) ? btt() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix btx() {
        return (this.meG.getHeight() > this.meF.getWidth() || this.meG.getHeight() > this.meF.getHeight()) ? btu() : b(PivotPoint.CENTER);
    }

    private Matrix bty() {
        return (this.meG.getHeight() > this.meF.getWidth() || this.meG.getHeight() > this.meF.getHeight()) ? btv() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
