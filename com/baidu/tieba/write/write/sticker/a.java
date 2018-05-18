package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hks;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hks = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hks, this.mMatrix, null);
        }
    }

    public int bEq() {
        if (this.hks == null) {
            return 0;
        }
        return this.hks.getWidth();
    }

    public int bEr() {
        if (this.hks == null) {
            return 0;
        }
        return this.hks.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bEs() {
        return this.hks;
    }
}
