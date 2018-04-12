package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hjr;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hjr = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hjr, this.mMatrix, null);
        }
    }

    public int bEs() {
        if (this.hjr == null) {
            return 0;
        }
        return this.hjr.getWidth();
    }

    public int bEt() {
        if (this.hjr == null) {
            return 0;
        }
        return this.hjr.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bEu() {
        return this.hjr;
    }
}
