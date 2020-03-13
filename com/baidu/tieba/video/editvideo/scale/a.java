package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b kxI;
    private b kxJ;

    public a(b bVar, b bVar2) {
        this.kxI = bVar;
        this.kxJ = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aZD();
            case FIT_XY:
                return aZw();
            case FIT_CENTER:
                return aZy();
            case FIT_START:
                return aZx();
            case FIT_END:
                return aZz();
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
                return aZA();
            case CENTER_INSIDE:
                return aZB();
            case END_INSIDE:
                return aZC();
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
                return h(f, f2, 0.0f, this.kxI.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.kxI.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.kxI.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.kxI.getWidth() / 2.0f, this.kxI.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.kxI.getWidth() / 2.0f, this.kxI.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.kxI.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.kxI.getWidth(), this.kxI.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.kxI.getWidth(), this.kxI.getHeight());
            default:
                return null;
        }
    }

    private Matrix aZD() {
        return a(this.kxJ.getWidth() / this.kxI.getWidth(), this.kxJ.getHeight() / this.kxI.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.kxI.getWidth() / this.kxJ.getWidth();
        float height = this.kxI.getHeight() / this.kxJ.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix aZw() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aZx() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aZy() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aZz() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.kxJ.getWidth() / this.kxI.getWidth(), this.kxJ.getHeight() / this.kxI.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.kxI.getWidth() / this.kxJ.getWidth();
        float height = this.kxI.getHeight() / this.kxJ.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aZA() {
        return (this.kxJ.getHeight() > this.kxI.getWidth() || this.kxJ.getHeight() > this.kxI.getHeight()) ? aZx() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aZB() {
        return (this.kxJ.getHeight() > this.kxI.getWidth() || this.kxJ.getHeight() > this.kxI.getHeight()) ? aZy() : b(PivotPoint.CENTER);
    }

    private Matrix aZC() {
        return (this.kxJ.getHeight() > this.kxI.getWidth() || this.kxJ.getHeight() > this.kxI.getHeight()) ? aZz() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
