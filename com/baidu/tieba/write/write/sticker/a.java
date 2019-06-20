package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jOx;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jOx = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jOx, this.mMatrix, null);
        }
    }

    public int czU() {
        if (this.jOx == null) {
            return 0;
        }
        return this.jOx.getWidth();
    }

    public int czV() {
        if (this.jOx == null) {
            return 0;
        }
        return this.jOx.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap czW() {
        return this.jOx;
    }
}
