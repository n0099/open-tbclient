package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap ogi;

    public a(Bitmap bitmap) {
        this.ogi = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ogi, this.mMatrix, null);
        }
    }

    public int ect() {
        if (this.ogi == null) {
            return 0;
        }
        return this.ogi.getWidth();
    }

    public int ecu() {
        if (this.ogi == null) {
            return 0;
        }
        return this.ogi.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap ecv() {
        return this.ogi;
    }
}
