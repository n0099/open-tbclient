package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b iXy;
    private b iXz;

    public a(b bVar, b bVar2) {
        this.iXy = bVar;
        this.iXz = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return axQ();
            case FIT_XY:
                return axJ();
            case FIT_CENTER:
                return axL();
            case FIT_START:
                return axK();
            case FIT_END:
                return axM();
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
                return axN();
            case CENTER_INSIDE:
                return axO();
            case END_INSIDE:
                return axP();
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
                return i(f, f2, 0.0f, this.iXy.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.iXy.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.iXy.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.iXy.getWidth() / 2.0f, this.iXy.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.iXy.getWidth() / 2.0f, this.iXy.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.iXy.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.iXy.getWidth(), this.iXy.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.iXy.getWidth(), this.iXy.getHeight());
            default:
                return null;
        }
    }

    private Matrix axQ() {
        return a(this.iXz.getWidth() / this.iXy.getWidth(), this.iXz.getHeight() / this.iXy.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.iXy.getWidth() / this.iXz.getWidth();
        float height = this.iXy.getHeight() / this.iXz.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix axJ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix axK() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix axL() {
        return a(PivotPoint.CENTER);
    }

    private Matrix axM() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.iXz.getWidth() / this.iXy.getWidth(), this.iXz.getHeight() / this.iXy.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.iXy.getWidth() / this.iXz.getWidth();
        float height = this.iXy.getHeight() / this.iXz.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix axN() {
        return (this.iXz.getHeight() > this.iXy.getWidth() || this.iXz.getHeight() > this.iXy.getHeight()) ? axK() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix axO() {
        return (this.iXz.getHeight() > this.iXy.getWidth() || this.iXz.getHeight() > this.iXy.getHeight()) ? axL() : b(PivotPoint.CENTER);
    }

    private Matrix axP() {
        return (this.iXz.getHeight() > this.iXy.getWidth() || this.iXz.getHeight() > this.iXy.getHeight()) ? axM() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
