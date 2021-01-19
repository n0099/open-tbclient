package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes7.dex */
public class a {
    private b nDp;
    private b nDq;

    public a(b bVar, b bVar2) {
        this.nDp = bVar;
        this.nDq = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bMp();
            case FIT_XY:
                return bMi();
            case FIT_CENTER:
                return bMk();
            case FIT_START:
                return bMj();
            case FIT_END:
                return bMl();
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
                return bMm();
            case CENTER_INSIDE:
                return bMn();
            case END_INSIDE:
                return bMo();
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
                return e(f, f2, 0.0f, this.nDp.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nDp.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nDp.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nDp.getWidth() / 2.0f, this.nDp.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nDp.getWidth() / 2.0f, this.nDp.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nDp.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nDp.getWidth(), this.nDp.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nDp.getWidth(), this.nDp.getHeight());
            default:
                return null;
        }
    }

    private Matrix bMp() {
        return a(this.nDq.getWidth() / this.nDp.getWidth(), this.nDq.getHeight() / this.nDp.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nDp.getWidth() / this.nDq.getWidth();
        float height = this.nDp.getHeight() / this.nDq.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bMi() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bMj() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bMk() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bMl() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nDq.getWidth() / this.nDp.getWidth(), this.nDq.getHeight() / this.nDp.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nDp.getWidth() / this.nDq.getWidth();
        float height = this.nDp.getHeight() / this.nDq.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bMm() {
        return (this.nDq.getHeight() > this.nDp.getWidth() || this.nDq.getHeight() > this.nDp.getHeight()) ? bMj() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bMn() {
        return (this.nDq.getHeight() > this.nDp.getWidth() || this.nDq.getHeight() > this.nDp.getHeight()) ? bMk() : b(PivotPoint.CENTER);
    }

    private Matrix bMo() {
        return (this.nDq.getHeight() > this.nDp.getWidth() || this.nDq.getHeight() > this.nDp.getHeight()) ? bMl() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
