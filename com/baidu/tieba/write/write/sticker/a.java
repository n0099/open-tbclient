package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hBE;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hBE = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hBE, this.mMatrix, null);
        }
    }

    public int bIJ() {
        if (this.hBE == null) {
            return 0;
        }
        return this.hBE.getWidth();
    }

    public int bIK() {
        if (this.hBE == null) {
            return 0;
        }
        return this.hBE.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bIL() {
        return this.hBE;
    }
}
