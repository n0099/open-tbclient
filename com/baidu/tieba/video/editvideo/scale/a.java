package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b hvs;
    private b hvt;

    public a(b bVar, b bVar2) {
        this.hvs = bVar;
        this.hvt = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Wm();
            case FIT_XY:
                return Wf();
            case FIT_CENTER:
                return Wh();
            case FIT_START:
                return Wg();
            case FIT_END:
                return Wi();
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
                return Wj();
            case CENTER_INSIDE:
                return Wk();
            case END_INSIDE:
                return Wl();
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
                return i(f, f2, 0.0f, this.hvs.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.hvs.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.hvs.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.hvs.getWidth() / 2.0f, this.hvs.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.hvs.getWidth() / 2.0f, this.hvs.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.hvs.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.hvs.getWidth(), this.hvs.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.hvs.getWidth(), this.hvs.getHeight());
            default:
                return null;
        }
    }

    private Matrix Wm() {
        return a(this.hvt.getWidth() / this.hvs.getWidth(), this.hvt.getHeight() / this.hvs.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hvs.getWidth() / this.hvt.getWidth();
        float height = this.hvs.getHeight() / this.hvt.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Wf() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Wg() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Wh() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Wi() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hvt.getWidth() / this.hvs.getWidth(), this.hvt.getHeight() / this.hvs.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hvs.getWidth() / this.hvt.getWidth();
        float height = this.hvs.getHeight() / this.hvt.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Wj() {
        return (this.hvt.getHeight() > this.hvs.getWidth() || this.hvt.getHeight() > this.hvs.getHeight()) ? Wg() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Wk() {
        return (this.hvt.getHeight() > this.hvs.getWidth() || this.hvt.getHeight() > this.hvs.getHeight()) ? Wh() : b(PivotPoint.CENTER);
    }

    private Matrix Wl() {
        return (this.hvt.getHeight() > this.hvs.getWidth() || this.hvt.getHeight() > this.hvs.getHeight()) ? Wi() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
