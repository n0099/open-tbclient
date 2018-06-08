package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gZj;
    private b gZk;

    public a(b bVar, b bVar2) {
        this.gZj = bVar;
        this.gZk = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return RL();
            case FIT_XY:
                return RE();
            case FIT_CENTER:
                return RG();
            case FIT_START:
                return RF();
            case FIT_END:
                return RH();
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
                return RI();
            case CENTER_INSIDE:
                return RJ();
            case END_INSIDE:
                return RK();
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
                return h(f, f2, 0.0f, this.gZj.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.gZj.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.gZj.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.gZj.getWidth() / 2.0f, this.gZj.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.gZj.getWidth() / 2.0f, this.gZj.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.gZj.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.gZj.getWidth(), this.gZj.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.gZj.getWidth(), this.gZj.getHeight());
            default:
                return null;
        }
    }

    private Matrix RL() {
        return a(this.gZk.getWidth() / this.gZj.getWidth(), this.gZk.getHeight() / this.gZj.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gZj.getWidth() / this.gZk.getWidth();
        float height = this.gZj.getHeight() / this.gZk.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix RE() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix RF() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix RG() {
        return a(PivotPoint.CENTER);
    }

    private Matrix RH() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gZk.getWidth() / this.gZj.getWidth(), this.gZk.getHeight() / this.gZj.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gZj.getWidth() / this.gZk.getWidth();
        float height = this.gZj.getHeight() / this.gZk.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix RI() {
        return (this.gZk.getHeight() > this.gZj.getWidth() || this.gZk.getHeight() > this.gZj.getHeight()) ? RF() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix RJ() {
        return (this.gZk.getHeight() > this.gZj.getWidth() || this.gZk.getHeight() > this.gZj.getHeight()) ? RG() : b(PivotPoint.CENTER);
    }

    private Matrix RK() {
        return (this.gZk.getHeight() > this.gZj.getWidth() || this.gZk.getHeight() > this.gZj.getHeight()) ? RH() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
