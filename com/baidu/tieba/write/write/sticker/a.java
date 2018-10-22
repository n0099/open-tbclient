package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hRq;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hRq = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hRq, this.mMatrix, null);
        }
    }

    public int bOP() {
        if (this.hRq == null) {
            return 0;
        }
        return this.hRq.getWidth();
    }

    public int bOQ() {
        if (this.hRq == null) {
            return 0;
        }
        return this.hRq.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bOR() {
        return this.hRq;
    }
}
