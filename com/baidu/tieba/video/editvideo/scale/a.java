package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b htJ;
    private b htK;

    public a(b bVar, b bVar2) {
        this.htJ = bVar;
        this.htK = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return Wd();
            case FIT_XY:
                return VW();
            case FIT_CENTER:
                return VY();
            case FIT_START:
                return VX();
            case FIT_END:
                return VZ();
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
                return Wa();
            case CENTER_INSIDE:
                return Wb();
            case END_INSIDE:
                return Wc();
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
                return i(f, f2, 0.0f, this.htJ.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.htJ.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.htJ.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.htJ.getWidth() / 2.0f, this.htJ.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.htJ.getWidth() / 2.0f, this.htJ.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.htJ.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.htJ.getWidth(), this.htJ.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.htJ.getWidth(), this.htJ.getHeight());
            default:
                return null;
        }
    }

    private Matrix Wd() {
        return a(this.htK.getWidth() / this.htJ.getWidth(), this.htK.getHeight() / this.htJ.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.htJ.getWidth() / this.htK.getWidth();
        float height = this.htJ.getHeight() / this.htK.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix VW() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix VX() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix VY() {
        return a(PivotPoint.CENTER);
    }

    private Matrix VZ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.htK.getWidth() / this.htJ.getWidth(), this.htK.getHeight() / this.htJ.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.htJ.getWidth() / this.htK.getWidth();
        float height = this.htJ.getHeight() / this.htK.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix Wa() {
        return (this.htK.getHeight() > this.htJ.getWidth() || this.htK.getHeight() > this.htJ.getHeight()) ? VX() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix Wb() {
        return (this.htK.getHeight() > this.htJ.getWidth() || this.htK.getHeight() > this.htJ.getHeight()) ? VY() : b(PivotPoint.CENTER);
    }

    private Matrix Wc() {
        return (this.htK.getHeight() > this.htJ.getWidth() || this.htK.getHeight() > this.htJ.getHeight()) ? VZ() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
