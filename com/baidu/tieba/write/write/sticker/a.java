package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes7.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap odi;

    public a(Bitmap bitmap) {
        this.odi = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.odi, this.mMatrix, null);
        }
    }

    public int dXz() {
        if (this.odi == null) {
            return 0;
        }
        return this.odi.getWidth();
    }

    public int dXA() {
        if (this.odi == null) {
            return 0;
        }
        return this.odi.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dXB() {
        return this.odi;
    }
}
