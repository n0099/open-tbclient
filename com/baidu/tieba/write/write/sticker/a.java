package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap hNf;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hNf = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hNf, this.mMatrix, null);
        }
    }

    public int bJA() {
        if (this.hNf == null) {
            return 0;
        }
        return this.hNf.getWidth();
    }

    public int bJB() {
        if (this.hNf == null) {
            return 0;
        }
        return this.hNf.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bJC() {
        return this.hNf;
    }
}
