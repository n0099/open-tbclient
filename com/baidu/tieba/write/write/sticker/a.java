package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hKd;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hKd = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hKd, this.mMatrix, null);
        }
    }

    public int bLE() {
        if (this.hKd == null) {
            return 0;
        }
        return this.hKd.getWidth();
    }

    public int bLF() {
        if (this.hKd == null) {
            return 0;
        }
        return this.hKd.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bLG() {
        return this.hKd;
    }
}
