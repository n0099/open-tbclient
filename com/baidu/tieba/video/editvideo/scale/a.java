package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gMH;
    private b gMI;

    public a(b bVar, b bVar2) {
        this.gMH = bVar;
        this.gMI = bVar2;
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
                return g(f, f2, 0.0f, this.gMH.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return g(f, f2, 0.0f, this.gMH.getHeight());
            case CENTER_TOP:
                return g(f, f2, this.gMH.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return g(f, f2, this.gMH.getWidth() / 2.0f, this.gMH.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return g(f, f2, this.gMH.getWidth() / 2.0f, this.gMH.getHeight());
            case RIGHT_TOP:
                return g(f, f2, this.gMH.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return g(f, f2, this.gMH.getWidth(), this.gMH.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return g(f, f2, this.gMH.getWidth(), this.gMH.getHeight());
            default:
                return null;
        }
    }

    private Matrix Oo() {
        return a(this.gMI.getWidth() / this.gMH.getWidth(), this.gMI.getHeight() / this.gMH.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gMH.getWidth() / this.gMI.getWidth();
        float height = this.gMH.getHeight() / this.gMI.getHeight();
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
        return a(this.gMI.getWidth() / this.gMH.getWidth(), this.gMI.getHeight() / this.gMH.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gMH.getWidth() / this.gMI.getWidth();
        float height = this.gMH.getHeight() / this.gMI.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Ol() {
        return (this.gMI.getHeight() > this.gMH.getWidth() || this.gMI.getHeight() > this.gMH.getHeight()) ? Oi() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Om() {
        return (this.gMI.getHeight() > this.gMH.getWidth() || this.gMI.getHeight() > this.gMH.getHeight()) ? Oj() : b(PivotPoint.CENTER);
    }

    private Matrix On() {
        return (this.gMI.getHeight() > this.gMH.getWidth() || this.gMI.getHeight() > this.gMH.getHeight()) ? Ok() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
