package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b nHT;
    private b nHU;

    public a(b bVar, b bVar2) {
        this.nHT = bVar;
        this.nHU = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bQh();
            case FIT_XY:
                return bQa();
            case FIT_CENTER:
                return bQc();
            case FIT_START:
                return bQb();
            case FIT_END:
                return bQd();
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
                return bQe();
            case CENTER_INSIDE:
                return bQf();
            case END_INSIDE:
                return bQg();
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
                return e(f, f2, 0.0f, this.nHT.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.nHT.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.nHT.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.nHT.getWidth() / 2.0f, this.nHT.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.nHT.getWidth() / 2.0f, this.nHT.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.nHT.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.nHT.getWidth(), this.nHT.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.nHT.getWidth(), this.nHT.getHeight());
            default:
                return null;
        }
    }

    private Matrix bQh() {
        return a(this.nHU.getWidth() / this.nHT.getWidth(), this.nHU.getHeight() / this.nHT.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.nHT.getWidth() / this.nHU.getWidth();
        float height = this.nHT.getHeight() / this.nHU.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bQa() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bQb() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bQc() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bQd() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.nHU.getWidth() / this.nHT.getWidth(), this.nHU.getHeight() / this.nHT.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.nHT.getWidth() / this.nHU.getWidth();
        float height = this.nHT.getHeight() / this.nHU.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bQe() {
        return (this.nHU.getHeight() > this.nHT.getWidth() || this.nHU.getHeight() > this.nHT.getHeight()) ? bQb() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bQf() {
        return (this.nHU.getHeight() > this.nHT.getWidth() || this.nHU.getHeight() > this.nHT.getHeight()) ? bQc() : b(PivotPoint.CENTER);
    }

    private Matrix bQg() {
        return (this.nHU.getHeight() > this.nHT.getWidth() || this.nHU.getHeight() > this.nHT.getHeight()) ? bQd() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
