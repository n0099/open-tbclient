package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private b heB;
    private b heC;

    public a(b bVar, b bVar2) {
        this.heB = bVar;
        this.heC = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Su();
            case FIT_XY:
                return Sn();
            case FIT_CENTER:
                return Sp();
            case FIT_START:
                return So();
            case FIT_END:
                return Sq();
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
                return Sr();
            case CENTER_INSIDE:
                return Ss();
            case END_INSIDE:
                return St();
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
                return h(f, f2, 0.0f, this.heB.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.heB.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.heB.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.heB.getWidth() / 2.0f, this.heB.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.heB.getWidth() / 2.0f, this.heB.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.heB.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.heB.getWidth(), this.heB.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.heB.getWidth(), this.heB.getHeight());
            default:
                return null;
        }
    }

    private Matrix Su() {
        return a(this.heC.getWidth() / this.heB.getWidth(), this.heC.getHeight() / this.heB.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.heB.getWidth() / this.heC.getWidth();
        float height = this.heB.getHeight() / this.heC.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix Sn() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix So() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix Sp() {
        return a(PivotPoint.CENTER);
    }

    private Matrix Sq() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.heC.getWidth() / this.heB.getWidth(), this.heC.getHeight() / this.heB.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.heB.getWidth() / this.heC.getWidth();
        float height = this.heB.getHeight() / this.heC.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Sr() {
        return (this.heC.getHeight() > this.heB.getWidth() || this.heC.getHeight() > this.heB.getHeight()) ? So() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Ss() {
        return (this.heC.getHeight() > this.heB.getWidth() || this.heC.getHeight() > this.heB.getHeight()) ? Sp() : b(PivotPoint.CENTER);
    }

    private Matrix St() {
        return (this.heC.getHeight() > this.heB.getWidth() || this.heC.getHeight() > this.heB.getHeight()) ? Sq() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
