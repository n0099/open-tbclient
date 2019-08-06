package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b jxC;
    private b jxD;

    public a(b bVar, b bVar2) {
        this.jxC = bVar;
        this.jxD = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aEo();
            case FIT_XY:
                return aEh();
            case FIT_CENTER:
                return aEj();
            case FIT_START:
                return aEi();
            case FIT_END:
                return aEk();
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
                return aEl();
            case CENTER_INSIDE:
                return aEm();
            case END_INSIDE:
                return aEn();
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
                return i(f, f2, 0.0f, this.jxC.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.jxC.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.jxC.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.jxC.getWidth() / 2.0f, this.jxC.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.jxC.getWidth() / 2.0f, this.jxC.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.jxC.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.jxC.getWidth(), this.jxC.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.jxC.getWidth(), this.jxC.getHeight());
            default:
                return null;
        }
    }

    private Matrix aEo() {
        return a(this.jxD.getWidth() / this.jxC.getWidth(), this.jxD.getHeight() / this.jxC.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.jxC.getWidth() / this.jxD.getWidth();
        float height = this.jxC.getHeight() / this.jxD.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix aEh() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aEi() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aEj() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aEk() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.jxD.getWidth() / this.jxC.getWidth(), this.jxD.getHeight() / this.jxC.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.jxC.getWidth() / this.jxD.getWidth();
        float height = this.jxC.getHeight() / this.jxD.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aEl() {
        return (this.jxD.getHeight() > this.jxC.getWidth() || this.jxD.getHeight() > this.jxC.getHeight()) ? aEi() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aEm() {
        return (this.jxD.getHeight() > this.jxC.getWidth() || this.jxD.getHeight() > this.jxC.getHeight()) ? aEj() : b(PivotPoint.CENTER);
    }

    private Matrix aEn() {
        return (this.jxD.getHeight() > this.jxC.getWidth() || this.jxD.getHeight() > this.jxC.getHeight()) ? aEk() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
