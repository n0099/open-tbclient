package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes13.dex */
public class a {
    private Bitmap kWX;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kWX = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kWX, this.mMatrix, null);
        }
    }

    public int cXE() {
        if (this.kWX == null) {
            return 0;
        }
        return this.kWX.getWidth();
    }

    public int cXF() {
        if (this.kWX == null) {
            return 0;
        }
        return this.kWX.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cXG() {
        return this.kWX;
    }
}
