package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b hdo;
    private b hdp;

    public a(b bVar, b bVar2) {
        this.hdo = bVar;
        this.hdp = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Si();
            case FIT_XY:
                return Sb();
            case FIT_CENTER:
                return Sd();
            case FIT_START:
                return Sc();
            case FIT_END:
                return Se();
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
                return Sf();
            case CENTER_INSIDE:
                return Sg();
            case END_INSIDE:
                return Sh();
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
                return h(f, f2, 0.0f, this.hdo.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.hdo.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.hdo.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.hdo.getWidth() / 2.0f, this.hdo.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.hdo.getWidth() / 2.0f, this.hdo.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.hdo.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.hdo.getWidth(), this.hdo.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.hdo.getWidth(), this.hdo.getHeight());
            default:
                return null;
        }
    }

    private Matrix Si() {
        return a(this.hdp.getWidth() / this.hdo.getWidth(), this.hdp.getHeight() / this.hdo.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hdo.getWidth() / this.hdp.getWidth();
        float height = this.hdo.getHeight() / this.hdp.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Sb() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Sc() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Sd() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Se() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hdp.getWidth() / this.hdo.getWidth(), this.hdp.getHeight() / this.hdo.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hdo.getWidth() / this.hdp.getWidth();
        float height = this.hdo.getHeight() / this.hdp.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Sf() {
        return (this.hdp.getHeight() > this.hdo.getWidth() || this.hdp.getHeight() > this.hdo.getHeight()) ? Sc() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Sg() {
        return (this.hdp.getHeight() > this.hdo.getWidth() || this.hdp.getHeight() > this.hdo.getHeight()) ? Sd() : b(PivotPoint.CENTER);
    }

    private Matrix Sh() {
        return (this.hdp.getHeight() > this.hdo.getWidth() || this.hdp.getHeight() > this.hdo.getHeight()) ? Se() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
