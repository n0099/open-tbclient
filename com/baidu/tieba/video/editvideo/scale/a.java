package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b heA;
    private b heB;

    public a(b bVar, b bVar2) {
        this.heA = bVar;
        this.heB = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Sq();
            case FIT_XY:
                return Sj();
            case FIT_CENTER:
                return Sl();
            case FIT_START:
                return Sk();
            case FIT_END:
                return Sm();
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
                return Sn();
            case CENTER_INSIDE:
                return So();
            case END_INSIDE:
                return Sp();
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
                return h(f, f2, 0.0f, this.heA.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.heA.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.heA.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.heA.getWidth() / 2.0f, this.heA.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.heA.getWidth() / 2.0f, this.heA.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.heA.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.heA.getWidth(), this.heA.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.heA.getWidth(), this.heA.getHeight());
            default:
                return null;
        }
    }

    private Matrix Sq() {
        return a(this.heB.getWidth() / this.heA.getWidth(), this.heB.getHeight() / this.heA.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.heA.getWidth() / this.heB.getWidth();
        float height = this.heA.getHeight() / this.heB.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Sj() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix Sk() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Sl() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Sm() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.heB.getWidth() / this.heA.getWidth(), this.heB.getHeight() / this.heA.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.heA.getWidth() / this.heB.getWidth();
        float height = this.heA.getHeight() / this.heB.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Sn() {
        return (this.heB.getHeight() > this.heA.getWidth() || this.heB.getHeight() > this.heA.getHeight()) ? Sk() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix So() {
        return (this.heB.getHeight() > this.heA.getWidth() || this.heB.getHeight() > this.heA.getHeight()) ? Sl() : b(PivotPoint.CENTER);
    }

    private Matrix Sp() {
        return (this.heB.getHeight() > this.heA.getWidth() || this.heB.getHeight() > this.heA.getHeight()) ? Sm() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
