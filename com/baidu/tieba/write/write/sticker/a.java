package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap ogk;

    public a(Bitmap bitmap) {
        this.ogk = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ogk, this.mMatrix, null);
        }
    }

    public int ecu() {
        if (this.ogk == null) {
            return 0;
        }
        return this.ogk.getWidth();
    }

    public int ecv() {
        if (this.ogk == null) {
            return 0;
        }
        return this.ogk.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap ecw() {
        return this.ogk;
    }
}
