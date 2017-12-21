package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b gSA;
    private b gSB;

    public a(b bVar, b bVar2) {
        this.gSA = bVar;
        this.gSB = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return NH();
            case FIT_XY:
                return NA();
            case FIT_CENTER:
                return NC();
            case FIT_START:
                return NB();
            case FIT_END:
                return ND();
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
                return NE();
            case CENTER_INSIDE:
                return NF();
            case END_INSIDE:
                return NG();
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
                return f(f, f2, 0.0f, this.gSA.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return f(f, f2, 0.0f, this.gSA.getHeight());
            case CENTER_TOP:
                return f(f, f2, this.gSA.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return f(f, f2, this.gSA.getWidth() / 2.0f, this.gSA.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return f(f, f2, this.gSA.getWidth() / 2.0f, this.gSA.getHeight());
            case RIGHT_TOP:
                return f(f, f2, this.gSA.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return f(f, f2, this.gSA.getWidth(), this.gSA.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return f(f, f2, this.gSA.getWidth(), this.gSA.getHeight());
            default:
                return null;
        }
    }

    private Matrix NH() {
        return a(this.gSB.getWidth() / this.gSA.getWidth(), this.gSB.getHeight() / this.gSA.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gSA.getWidth() / this.gSB.getWidth();
        float height = this.gSA.getHeight() / this.gSB.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix NA() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix NB() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix NC() {
        return a(PivotPoint.CENTER);
    }

    private Matrix ND() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gSB.getWidth() / this.gSA.getWidth(), this.gSB.getHeight() / this.gSA.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gSA.getWidth() / this.gSB.getWidth();
        float height = this.gSA.getHeight() / this.gSB.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix NE() {
        return (this.gSB.getHeight() > this.gSA.getWidth() || this.gSB.getHeight() > this.gSA.getHeight()) ? NB() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix NF() {
        return (this.gSB.getHeight() > this.gSA.getWidth() || this.gSB.getHeight() > this.gSA.getHeight()) ? NC() : b(PivotPoint.CENTER);
    }

    private Matrix NG() {
        return (this.gSB.getHeight() > this.gSA.getWidth() || this.gSB.getHeight() > this.gSA.getHeight()) ? ND() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
