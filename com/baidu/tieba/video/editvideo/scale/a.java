package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b kzn;
    private b kzo;

    public a(b bVar, b bVar2) {
        this.kzn = bVar;
        this.kzo = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aZH();
            case FIT_XY:
                return aZA();
            case FIT_CENTER:
                return aZC();
            case FIT_START:
                return aZB();
            case FIT_END:
                return aZD();
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
                return aZE();
            case CENTER_INSIDE:
                return aZF();
            case END_INSIDE:
                return aZG();
            default:
                return null;
        }
    }

    private Matrix h(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return h(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return h(f, f2, 0.0f, this.kzn.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.kzn.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.kzn.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.kzn.getWidth() / 2.0f, this.kzn.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.kzn.getWidth() / 2.0f, this.kzn.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.kzn.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.kzn.getWidth(), this.kzn.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.kzn.getWidth(), this.kzn.getHeight());
            default:
                return null;
        }
    }

    private Matrix aZH() {
        return a(this.kzo.getWidth() / this.kzn.getWidth(), this.kzo.getHeight() / this.kzn.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.kzn.getWidth() / this.kzo.getWidth();
        float height = this.kzn.getHeight() / this.kzo.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix aZA() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aZB() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aZC() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aZD() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.kzo.getWidth() / this.kzn.getWidth(), this.kzo.getHeight() / this.kzn.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.kzn.getWidth() / this.kzo.getWidth();
        float height = this.kzn.getHeight() / this.kzo.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aZE() {
        return (this.kzo.getHeight() > this.kzn.getWidth() || this.kzo.getHeight() > this.kzn.getHeight()) ? aZB() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aZF() {
        return (this.kzo.getHeight() > this.kzn.getWidth() || this.kzo.getHeight() > this.kzn.getHeight()) ? aZC() : b(PivotPoint.CENTER);
    }

    private Matrix aZG() {
        return (this.kzo.getHeight() > this.kzn.getWidth() || this.kzo.getHeight() > this.kzn.getHeight()) ? aZD() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
