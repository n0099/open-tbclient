package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gNH;
    private b gNI;

    public a(b bVar, b bVar2) {
        this.gNH = bVar;
        this.gNI = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Om();
            case FIT_XY:
                return Of();
            case FIT_CENTER:
                return Oh();
            case FIT_START:
                return Og();
            case FIT_END:
                return Oi();
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
                return Oj();
            case CENTER_INSIDE:
                return Ok();
            case END_INSIDE:
                return Ol();
            default:
                return null;
        }
    }

    private Matrix g(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return g(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return g(f, f2, 0.0f, this.gNH.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return g(f, f2, 0.0f, this.gNH.getHeight());
            case CENTER_TOP:
                return g(f, f2, this.gNH.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return g(f, f2, this.gNH.getWidth() / 2.0f, this.gNH.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return g(f, f2, this.gNH.getWidth() / 2.0f, this.gNH.getHeight());
            case RIGHT_TOP:
                return g(f, f2, this.gNH.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return g(f, f2, this.gNH.getWidth(), this.gNH.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return g(f, f2, this.gNH.getWidth(), this.gNH.getHeight());
            default:
                return null;
        }
    }

    private Matrix Om() {
        return a(this.gNI.getWidth() / this.gNH.getWidth(), this.gNI.getHeight() / this.gNH.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gNH.getWidth() / this.gNI.getWidth();
        float height = this.gNH.getHeight() / this.gNI.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Of() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Og() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Oh() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Oi() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gNI.getWidth() / this.gNH.getWidth(), this.gNI.getHeight() / this.gNH.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gNH.getWidth() / this.gNI.getWidth();
        float height = this.gNH.getHeight() / this.gNI.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Oj() {
        return (this.gNI.getHeight() > this.gNH.getWidth() || this.gNI.getHeight() > this.gNH.getHeight()) ? Og() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Ok() {
        return (this.gNI.getHeight() > this.gNH.getWidth() || this.gNI.getHeight() > this.gNH.getHeight()) ? Oh() : b(PivotPoint.CENTER);
    }

    private Matrix Ol() {
        return (this.gNI.getHeight() > this.gNH.getWidth() || this.gNI.getHeight() > this.gNH.getHeight()) ? Oi() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
