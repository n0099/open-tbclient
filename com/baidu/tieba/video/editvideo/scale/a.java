package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes17.dex */
public class a {
    private b mwr;
    private b mws;

    public a(b bVar, b bVar2) {
        this.mwr = bVar;
        this.mws = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bCu();
            case FIT_XY:
                return bCn();
            case FIT_CENTER:
                return bCp();
            case FIT_START:
                return bCo();
            case FIT_END:
                return bCq();
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
                return bCr();
            case CENTER_INSIDE:
                return bCs();
            case END_INSIDE:
                return bCt();
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
                return e(f, f2, 0.0f, this.mwr.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.mwr.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.mwr.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.mwr.getWidth() / 2.0f, this.mwr.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.mwr.getWidth() / 2.0f, this.mwr.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.mwr.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.mwr.getWidth(), this.mwr.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.mwr.getWidth(), this.mwr.getHeight());
            default:
                return null;
        }
    }

    private Matrix bCu() {
        return a(this.mws.getWidth() / this.mwr.getWidth(), this.mws.getHeight() / this.mwr.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.mwr.getWidth() / this.mws.getWidth();
        float height = this.mwr.getHeight() / this.mws.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix bCn() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bCo() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bCp() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bCq() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.mws.getWidth() / this.mwr.getWidth(), this.mws.getHeight() / this.mwr.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.mwr.getWidth() / this.mws.getWidth();
        float height = this.mwr.getHeight() / this.mws.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bCr() {
        return (this.mws.getHeight() > this.mwr.getWidth() || this.mws.getHeight() > this.mwr.getHeight()) ? bCo() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bCs() {
        return (this.mws.getHeight() > this.mwr.getWidth() || this.mws.getHeight() > this.mwr.getHeight()) ? bCp() : b(PivotPoint.CENTER);
    }

    private Matrix bCt() {
        return (this.mws.getHeight() > this.mwr.getWidth() || this.mws.getHeight() > this.mwr.getHeight()) ? bCq() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
