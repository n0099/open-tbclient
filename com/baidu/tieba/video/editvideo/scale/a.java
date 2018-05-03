package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gME;
    private b gMF;

    public a(b bVar, b bVar2) {
        this.gME = bVar;
        this.gMF = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Oo();
            case FIT_XY:
                return Oh();
            case FIT_CENTER:
                return Oj();
            case FIT_START:
                return Oi();
            case FIT_END:
                return Ok();
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
                return Ol();
            case CENTER_INSIDE:
                return Om();
            case END_INSIDE:
                return On();
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
                return g(f, f2, 0.0f, this.gME.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return g(f, f2, 0.0f, this.gME.getHeight());
            case CENTER_TOP:
                return g(f, f2, this.gME.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return g(f, f2, this.gME.getWidth() / 2.0f, this.gME.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return g(f, f2, this.gME.getWidth() / 2.0f, this.gME.getHeight());
            case RIGHT_TOP:
                return g(f, f2, this.gME.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return g(f, f2, this.gME.getWidth(), this.gME.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return g(f, f2, this.gME.getWidth(), this.gME.getHeight());
            default:
                return null;
        }
    }

    private Matrix Oo() {
        return a(this.gMF.getWidth() / this.gME.getWidth(), this.gMF.getHeight() / this.gME.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gME.getWidth() / this.gMF.getWidth();
        float height = this.gME.getHeight() / this.gMF.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Oh() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Oi() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Oj() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Ok() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gMF.getWidth() / this.gME.getWidth(), this.gMF.getHeight() / this.gME.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gME.getWidth() / this.gMF.getWidth();
        float height = this.gME.getHeight() / this.gMF.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Ol() {
        return (this.gMF.getHeight() > this.gME.getWidth() || this.gMF.getHeight() > this.gME.getHeight()) ? Oi() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Om() {
        return (this.gMF.getHeight() > this.gME.getWidth() || this.gMF.getHeight() > this.gME.getHeight()) ? Oj() : b(PivotPoint.CENTER);
    }

    private Matrix On() {
        return (this.gMF.getHeight() > this.gME.getWidth() || this.gMF.getHeight() > this.gME.getHeight()) ? Ok() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
