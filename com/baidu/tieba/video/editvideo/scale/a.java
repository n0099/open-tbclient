package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gFJ;
    private b gFK;

    public a(b bVar, b bVar2) {
        this.gFJ = bVar;
        this.gFK = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Nd();
            case FIT_XY:
                return MW();
            case FIT_CENTER:
                return MY();
            case FIT_START:
                return MX();
            case FIT_END:
                return MZ();
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
                return Na();
            case CENTER_INSIDE:
                return Nb();
            case END_INSIDE:
                return Nc();
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
                return f(f, f2, 0.0f, this.gFJ.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return f(f, f2, 0.0f, this.gFJ.getHeight());
            case CENTER_TOP:
                return f(f, f2, this.gFJ.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return f(f, f2, this.gFJ.getWidth() / 2.0f, this.gFJ.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return f(f, f2, this.gFJ.getWidth() / 2.0f, this.gFJ.getHeight());
            case RIGHT_TOP:
                return f(f, f2, this.gFJ.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return f(f, f2, this.gFJ.getWidth(), this.gFJ.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return f(f, f2, this.gFJ.getWidth(), this.gFJ.getHeight());
            default:
                return null;
        }
    }

    private Matrix Nd() {
        return a(this.gFK.getWidth() / this.gFJ.getWidth(), this.gFK.getHeight() / this.gFJ.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gFJ.getWidth() / this.gFK.getWidth();
        float height = this.gFJ.getHeight() / this.gFK.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix MW() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix MX() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix MY() {
        return a(PivotPoint.CENTER);
    }

    private Matrix MZ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gFK.getWidth() / this.gFJ.getWidth(), this.gFK.getHeight() / this.gFJ.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gFJ.getWidth() / this.gFK.getWidth();
        float height = this.gFJ.getHeight() / this.gFK.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Na() {
        return (this.gFK.getHeight() > this.gFJ.getWidth() || this.gFK.getHeight() > this.gFJ.getHeight()) ? MX() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Nb() {
        return (this.gFK.getHeight() > this.gFJ.getWidth() || this.gFK.getHeight() > this.gFJ.getHeight()) ? MY() : b(PivotPoint.CENTER);
    }

    private Matrix Nc() {
        return (this.gFK.getHeight() > this.gFJ.getWidth() || this.gFK.getHeight() > this.gFJ.getHeight()) ? MZ() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
