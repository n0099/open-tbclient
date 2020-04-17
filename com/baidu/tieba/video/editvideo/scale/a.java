package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b ljE;
    private b ljF;

    public a(b bVar, b bVar2) {
        this.ljE = bVar;
        this.ljF = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bhL();
            case FIT_XY:
                return bhE();
            case FIT_CENTER:
                return bhG();
            case FIT_START:
                return bhF();
            case FIT_END:
                return bhH();
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
                return bhI();
            case CENTER_INSIDE:
                return bhJ();
            case END_INSIDE:
                return bhK();
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
                return e(f, f2, 0.0f, this.ljE.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.ljE.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.ljE.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.ljE.getWidth() / 2.0f, this.ljE.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.ljE.getWidth() / 2.0f, this.ljE.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.ljE.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.ljE.getWidth(), this.ljE.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.ljE.getWidth(), this.ljE.getHeight());
            default:
                return null;
        }
    }

    private Matrix bhL() {
        return a(this.ljF.getWidth() / this.ljE.getWidth(), this.ljF.getHeight() / this.ljE.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.ljE.getWidth() / this.ljF.getWidth();
        float height = this.ljE.getHeight() / this.ljF.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bhE() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bhF() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bhG() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bhH() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.ljF.getWidth() / this.ljE.getWidth(), this.ljF.getHeight() / this.ljE.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.ljE.getWidth() / this.ljF.getWidth();
        float height = this.ljE.getHeight() / this.ljF.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bhI() {
        return (this.ljF.getHeight() > this.ljE.getWidth() || this.ljF.getHeight() > this.ljE.getHeight()) ? bhF() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bhJ() {
        return (this.ljF.getHeight() > this.ljE.getWidth() || this.ljF.getHeight() > this.ljE.getHeight()) ? bhG() : b(PivotPoint.CENTER);
    }

    private Matrix bhK() {
        return (this.ljF.getHeight() > this.ljE.getWidth() || this.ljF.getHeight() > this.ljE.getHeight()) ? bhH() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
