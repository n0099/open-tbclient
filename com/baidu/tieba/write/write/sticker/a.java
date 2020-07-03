package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap mwr;

    public a(Bitmap bitmap) {
        this.mwr = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mwr, this.mMatrix, null);
        }
    }

    public int duk() {
        if (this.mwr == null) {
            return 0;
        }
        return this.mwr.getWidth();
    }

    public int dul() {
        if (this.mwr == null) {
            return 0;
        }
        return this.mwr.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dum() {
        return this.mwr;
    }
}
