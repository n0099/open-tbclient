package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes7.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap odj;

    public a(Bitmap bitmap) {
        this.odj = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.odj, this.mMatrix, null);
        }
    }

    public int dXz() {
        if (this.odj == null) {
            return 0;
        }
        return this.odj.getWidth();
    }

    public int dXA() {
        if (this.odj == null) {
            return 0;
        }
        return this.odj.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dXB() {
        return this.odj;
    }
}
