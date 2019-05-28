package com.baidu.tieba.video.editvideo.scale;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b jqk;
    private b jql;

    public a(b bVar, b bVar2) {
        this.jqk = bVar;
        this.jql = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aCW();
            case FIT_XY:
                return aCP();
            case FIT_CENTER:
                return aCR();
            case FIT_START:
                return aCQ();
            case FIT_END:
                return aCS();
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
                return aCT();
            case CENTER_INSIDE:
                return aCU();
            case END_INSIDE:
                return aCV();
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
                return i(f, f2, 0.0f, this.jqk.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.jqk.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.jqk.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.jqk.getWidth() / 2.0f, this.jqk.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.jqk.getWidth() / 2.0f, this.jqk.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.jqk.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.jqk.getWidth(), this.jqk.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.jqk.getWidth(), this.jqk.getHeight());
            default:
                return null;
        }
    }

    private Matrix aCW() {
        return a(this.jql.getWidth() / this.jqk.getWidth(), this.jql.getHeight() / this.jqk.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.jqk.getWidth() / this.jql.getWidth();
        float height = this.jqk.getHeight() / this.jql.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix aCP() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aCQ() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aCR() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aCS() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.jql.getWidth() / this.jqk.getWidth(), this.jql.getHeight() / this.jqk.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.jqk.getWidth() / this.jql.getWidth();
        float height = this.jqk.getHeight() / this.jql.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aCT() {
        return (this.jql.getHeight() > this.jqk.getWidth() || this.jql.getHeight() > this.jqk.getHeight()) ? aCQ() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aCU() {
        return (this.jql.getHeight() > this.jqk.getWidth() || this.jql.getHeight() > this.jqk.getHeight()) ? aCR() : b(PivotPoint.CENTER);
    }

    private Matrix aCV() {
        return (this.jql.getHeight() > this.jqk.getWidth() || this.jql.getHeight() > this.jqk.getHeight()) ? aCS() : b(PivotPoint.RIGHT_BOTTOM);
    }
}
