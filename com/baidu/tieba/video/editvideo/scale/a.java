package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b kxu;
    private b kxv;

    public a(b bVar, b bVar2) {
        this.kxu = bVar;
        this.kxv = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aZA();
            case FIT_XY:
                return aZt();
            case FIT_CENTER:
                return aZv();
            case FIT_START:
                return aZu();
            case FIT_END:
                return aZw();
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
                return aZx();
            case CENTER_INSIDE:
                return aZy();
            case END_INSIDE:
                return aZz();
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
                return h(f, f2, 0.0f, this.kxu.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.kxu.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.kxu.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.kxu.getWidth() / 2.0f, this.kxu.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.kxu.getWidth() / 2.0f, this.kxu.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.kxu.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.kxu.getWidth(), this.kxu.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.kxu.getWidth(), this.kxu.getHeight());
            default:
                return null;
        }
    }

    private Matrix aZA() {
        return a(this.kxv.getWidth() / this.kxu.getWidth(), this.kxv.getHeight() / this.kxu.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.kxu.getWidth() / this.kxv.getWidth();
        float height = this.kxu.getHeight() / this.kxv.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix aZt() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aZu() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aZv() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aZw() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.kxv.getWidth() / this.kxu.getWidth(), this.kxv.getHeight() / this.kxu.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.kxu.getWidth() / this.kxv.getWidth();
        float height = this.kxu.getHeight() / this.kxv.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aZx() {
        return (this.kxv.getHeight() > this.kxu.getWidth() || this.kxv.getHeight() > this.kxu.getHeight()) ? aZu() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aZy() {
        return (this.kxv.getHeight() > this.kxu.getWidth() || this.kxv.getHeight() > this.kxu.getHeight()) ? aZv() : b(PivotPoint.CENTER);
    }

    private Matrix aZz() {
        return (this.kxv.getHeight() > this.kxu.getWidth() || this.kxv.getHeight() > this.kxu.getHeight()) ? aZw() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
