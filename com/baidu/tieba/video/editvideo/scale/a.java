package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b niI;
    private b niJ;

    public a(b bVar, b bVar2) {
        this.niI = bVar;
        this.niJ = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bIm();
            case FIT_XY:
                return bIf();
            case FIT_CENTER:
                return bIh();
            case FIT_START:
                return bIg();
            case FIT_END:
                return bIi();
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
                return bIj();
            case CENTER_INSIDE:
                return bIk();
            case END_INSIDE:
                return bIl();
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
                return e(f, f2, 0.0f, this.niI.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.niI.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.niI.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.niI.getWidth() / 2.0f, this.niI.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.niI.getWidth() / 2.0f, this.niI.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.niI.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.niI.getWidth(), this.niI.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.niI.getWidth(), this.niI.getHeight());
            default:
                return null;
        }
    }

    private Matrix bIm() {
        return a(this.niJ.getWidth() / this.niI.getWidth(), this.niJ.getHeight() / this.niI.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.niI.getWidth() / this.niJ.getWidth();
        float height = this.niI.getHeight() / this.niJ.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bIf() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bIg() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bIh() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bIi() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.niJ.getWidth() / this.niI.getWidth(), this.niJ.getHeight() / this.niI.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.niI.getWidth() / this.niJ.getWidth();
        float height = this.niI.getHeight() / this.niJ.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bIj() {
        return (this.niJ.getHeight() > this.niI.getWidth() || this.niJ.getHeight() > this.niI.getHeight()) ? bIg() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bIk() {
        return (this.niJ.getHeight() > this.niI.getWidth() || this.niJ.getHeight() > this.niI.getHeight()) ? bIh() : b(PivotPoint.CENTER);
    }

    private Matrix bIl() {
        return (this.niJ.getHeight() > this.niI.getWidth() || this.niJ.getHeight() > this.niI.getHeight()) ? bIi() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
