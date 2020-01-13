package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b kwu;
    private b kwv;

    public a(b bVar, b bVar2) {
        this.kwu = bVar;
        this.kwv = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aXl();
            case FIT_XY:
                return aXe();
            case FIT_CENTER:
                return aXg();
            case FIT_START:
                return aXf();
            case FIT_END:
                return aXh();
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
                return aXi();
            case CENTER_INSIDE:
                return aXj();
            case END_INSIDE:
                return aXk();
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
                return h(f, f2, 0.0f, this.kwu.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.kwu.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.kwu.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.kwu.getWidth() / 2.0f, this.kwu.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.kwu.getWidth() / 2.0f, this.kwu.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.kwu.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.kwu.getWidth(), this.kwu.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.kwu.getWidth(), this.kwu.getHeight());
            default:
                return null;
        }
    }

    private Matrix aXl() {
        return a(this.kwv.getWidth() / this.kwu.getWidth(), this.kwv.getHeight() / this.kwu.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.kwu.getWidth() / this.kwv.getWidth();
        float height = this.kwu.getHeight() / this.kwv.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix aXe() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aXf() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aXg() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aXh() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.kwv.getWidth() / this.kwu.getWidth(), this.kwv.getHeight() / this.kwu.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.kwu.getWidth() / this.kwv.getWidth();
        float height = this.kwu.getHeight() / this.kwv.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aXi() {
        return (this.kwv.getHeight() > this.kwu.getWidth() || this.kwv.getHeight() > this.kwu.getHeight()) ? aXf() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aXj() {
        return (this.kwv.getHeight() > this.kwu.getWidth() || this.kwv.getHeight() > this.kwu.getHeight()) ? aXg() : b(PivotPoint.CENTER);
    }

    private Matrix aXk() {
        return (this.kwv.getHeight() > this.kwu.getWidth() || this.kwv.getHeight() > this.kwu.getHeight()) ? aXh() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
