package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b hpA;
    private b hpz;

    public a(b bVar, b bVar2) {
        this.hpz = bVar;
        this.hpA = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return UW();
            case FIT_XY:
                return UP();
            case FIT_CENTER:
                return UR();
            case FIT_START:
                return UQ();
            case FIT_END:
                return US();
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
                return UT();
            case CENTER_INSIDE:
                return UU();
            case END_INSIDE:
                return UV();
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
                return i(f, f2, 0.0f, this.hpz.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.hpz.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.hpz.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.hpz.getWidth() / 2.0f, this.hpz.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.hpz.getWidth() / 2.0f, this.hpz.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.hpz.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.hpz.getWidth(), this.hpz.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.hpz.getWidth(), this.hpz.getHeight());
            default:
                return null;
        }
    }

    private Matrix UW() {
        return a(this.hpA.getWidth() / this.hpz.getWidth(), this.hpA.getHeight() / this.hpz.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.hpz.getWidth() / this.hpA.getWidth();
        float height = this.hpz.getHeight() / this.hpA.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix UP() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix UQ() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix UR() {
        return a(PivotPoint.CENTER);
    }

    private Matrix US() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.hpA.getWidth() / this.hpz.getWidth(), this.hpA.getHeight() / this.hpz.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.hpz.getWidth() / this.hpA.getWidth();
        float height = this.hpz.getHeight() / this.hpA.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix UT() {
        return (this.hpA.getHeight() > this.hpz.getWidth() || this.hpA.getHeight() > this.hpz.getHeight()) ? UQ() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix UU() {
        return (this.hpA.getHeight() > this.hpz.getWidth() || this.hpA.getHeight() > this.hpz.getHeight()) ? UR() : b(PivotPoint.CENTER);
    }

    private Matrix UV() {
        return (this.hpA.getHeight() > this.hpz.getWidth() || this.hpA.getHeight() > this.hpz.getHeight()) ? US() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
