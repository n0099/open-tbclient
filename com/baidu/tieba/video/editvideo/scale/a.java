package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b ljI;
    private b ljJ;

    public a(b bVar, b bVar2) {
        this.ljI = bVar;
        this.ljJ = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bhJ();
            case FIT_XY:
                return bhC();
            case FIT_CENTER:
                return bhE();
            case FIT_START:
                return bhD();
            case FIT_END:
                return bhF();
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
                return bhG();
            case CENTER_INSIDE:
                return bhH();
            case END_INSIDE:
                return bhI();
            default:
                return null;
        }
    }

    private Matrix e(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.ljI.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.ljI.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.ljI.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.ljI.getWidth() / 2.0f, this.ljI.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.ljI.getWidth() / 2.0f, this.ljI.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.ljI.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.ljI.getWidth(), this.ljI.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.ljI.getWidth(), this.ljI.getHeight());
            default:
                return null;
        }
    }

    private Matrix bhJ() {
        return a(this.ljJ.getWidth() / this.ljI.getWidth(), this.ljJ.getHeight() / this.ljI.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.ljI.getWidth() / this.ljJ.getWidth();
        float height = this.ljI.getHeight() / this.ljJ.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bhC() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bhD() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bhE() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bhF() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.ljJ.getWidth() / this.ljI.getWidth(), this.ljJ.getHeight() / this.ljI.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.ljI.getWidth() / this.ljJ.getWidth();
        float height = this.ljI.getHeight() / this.ljJ.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bhG() {
        return (this.ljJ.getHeight() > this.ljI.getWidth() || this.ljJ.getHeight() > this.ljI.getHeight()) ? bhD() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bhH() {
        return (this.ljJ.getHeight() > this.ljI.getWidth() || this.ljJ.getHeight() > this.ljI.getHeight()) ? bhE() : b(PivotPoint.CENTER);
    }

    private Matrix bhI() {
        return (this.ljJ.getHeight() > this.ljI.getWidth() || this.ljJ.getHeight() > this.ljI.getHeight()) ? bhF() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
