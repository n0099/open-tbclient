package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gEB;
    private b gEC;

    public a(b bVar, b bVar2) {
        this.gEB = bVar;
        this.gEC = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return MS();
            case FIT_XY:
                return ML();
            case FIT_CENTER:
                return MN();
            case FIT_START:
                return MM();
            case FIT_END:
                return MO();
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
                return MP();
            case CENTER_INSIDE:
                return MQ();
            case END_INSIDE:
                return MR();
            default:
                return null;
        }
    }

    private Matrix f(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return f(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return f(f, f2, 0.0f, this.gEB.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return f(f, f2, 0.0f, this.gEB.getHeight());
            case CENTER_TOP:
                return f(f, f2, this.gEB.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return f(f, f2, this.gEB.getWidth() / 2.0f, this.gEB.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return f(f, f2, this.gEB.getWidth() / 2.0f, this.gEB.getHeight());
            case RIGHT_TOP:
                return f(f, f2, this.gEB.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return f(f, f2, this.gEB.getWidth(), this.gEB.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return f(f, f2, this.gEB.getWidth(), this.gEB.getHeight());
            default:
                return null;
        }
    }

    private Matrix MS() {
        return a(this.gEC.getWidth() / this.gEB.getWidth(), this.gEC.getHeight() / this.gEB.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gEB.getWidth() / this.gEC.getWidth();
        float height = this.gEB.getHeight() / this.gEC.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix ML() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix MM() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix MN() {
        return a(PivotPoint.CENTER);
    }

    private Matrix MO() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gEC.getWidth() / this.gEB.getWidth(), this.gEC.getHeight() / this.gEB.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gEB.getWidth() / this.gEC.getWidth();
        float height = this.gEB.getHeight() / this.gEC.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix MP() {
        return (this.gEC.getHeight() > this.gEB.getWidth() || this.gEC.getHeight() > this.gEB.getHeight()) ? MM() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix MQ() {
        return (this.gEC.getHeight() > this.gEB.getWidth() || this.gEC.getHeight() > this.gEB.getHeight()) ? MN() : b(PivotPoint.CENTER);
    }

    private Matrix MR() {
        return (this.gEC.getHeight() > this.gEB.getWidth() || this.gEC.getHeight() > this.gEB.getHeight()) ? MO() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
