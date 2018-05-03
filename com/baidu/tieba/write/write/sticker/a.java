package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hjo;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hjo = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hjo, this.mMatrix, null);
        }
    }

    public int bEs() {
        if (this.hjo == null) {
            return 0;
        }
        return this.hjo.getWidth();
    }

    public int bEt() {
        if (this.hjo == null) {
            return 0;
        }
        return this.hjo.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bEu() {
        return this.hjo;
    }
}
