package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b hmt;
    private b hmu;

    public a(b bVar, b bVar2) {
        this.hmt = bVar;
        this.hmu = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Uh();
            case FIT_XY:
                return Ua();
            case FIT_CENTER:
                return Uc();
            case FIT_START:
                return Ub();
            case FIT_END:
                return Ud();
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
                return Ue();
            case CENTER_INSIDE:
                return Uf();
            case END_INSIDE:
                return Ug();
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
                return i(f, f2, 0.0f, this.hmt.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.hmt.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.hmt.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.hmt.getWidth() / 2.0f, this.hmt.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.hmt.getWidth() / 2.0f, this.hmt.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.hmt.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.hmt.getWidth(), this.hmt.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.hmt.getWidth(), this.hmt.getHeight());
            default:
                return null;
        }
    }

    private Matrix Uh() {
        return a(this.hmu.getWidth() / this.hmt.getWidth(), this.hmu.getHeight() / this.hmt.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hmt.getWidth() / this.hmu.getWidth();
        float height = this.hmt.getHeight() / this.hmu.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Ua() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Ub() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Uc() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Ud() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hmu.getWidth() / this.hmt.getWidth(), this.hmu.getHeight() / this.hmt.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hmt.getWidth() / this.hmu.getWidth();
        float height = this.hmt.getHeight() / this.hmu.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Ue() {
        return (this.hmu.getHeight() > this.hmt.getWidth() || this.hmu.getHeight() > this.hmt.getHeight()) ? Ub() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Uf() {
        return (this.hmu.getHeight() > this.hmt.getWidth() || this.hmu.getHeight() > this.hmt.getHeight()) ? Uc() : b(PivotPoint.CENTER);
    }

    private Matrix Ug() {
        return (this.hmu.getHeight() > this.hmt.getWidth() || this.hmu.getHeight() > this.hmt.getHeight()) ? Ud() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
