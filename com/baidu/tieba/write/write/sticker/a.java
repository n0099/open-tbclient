package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap hND;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hND = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hND, this.mMatrix, null);
        }
    }

    public int bJF() {
        if (this.hND == null) {
            return 0;
        }
        return this.hND.getWidth();
    }

    public int bJG() {
        if (this.hND == null) {
            return 0;
        }
        return this.hND.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bJH() {
        return this.hND;
    }
}
