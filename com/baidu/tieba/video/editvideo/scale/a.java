package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b lXo;
    private b lXp;

    public a(b bVar, b bVar2) {
        this.lXo = bVar;
        this.lXp = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bqx();
            case FIT_XY:
                return bqq();
            case FIT_CENTER:
                return bqs();
            case FIT_START:
                return bqr();
            case FIT_END:
                return bqt();
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
                return bqu();
            case CENTER_INSIDE:
                return bqv();
            case END_INSIDE:
                return bqw();
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
                return e(f, f2, 0.0f, this.lXo.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.lXo.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.lXo.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.lXo.getWidth() / 2.0f, this.lXo.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.lXo.getWidth() / 2.0f, this.lXo.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.lXo.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.lXo.getWidth(), this.lXo.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.lXo.getWidth(), this.lXo.getHeight());
            default:
                return null;
        }
    }

    private Matrix bqx() {
        return a(this.lXp.getWidth() / this.lXo.getWidth(), this.lXp.getHeight() / this.lXo.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.lXo.getWidth() / this.lXp.getWidth();
        float height = this.lXo.getHeight() / this.lXp.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bqq() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bqr() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bqs() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bqt() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.lXp.getWidth() / this.lXo.getWidth(), this.lXp.getHeight() / this.lXo.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.lXo.getWidth() / this.lXp.getWidth();
        float height = this.lXo.getHeight() / this.lXp.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bqu() {
        return (this.lXp.getHeight() > this.lXo.getWidth() || this.lXp.getHeight() > this.lXo.getHeight()) ? bqr() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bqv() {
        return (this.lXp.getHeight() > this.lXo.getWidth() || this.lXp.getHeight() > this.lXo.getHeight()) ? bqs() : b(PivotPoint.CENTER);
    }

    private Matrix bqw() {
        return (this.lXp.getHeight() > this.lXo.getWidth() || this.lXp.getHeight() > this.lXo.getHeight()) ? bqt() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
