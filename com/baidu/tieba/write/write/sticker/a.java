package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap iak;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.iak = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.iak, this.mMatrix, null);
        }
    }

    public int bQt() {
        if (this.iak == null) {
            return 0;
        }
        return this.iak.getWidth();
    }

    public int bQu() {
        if (this.iak == null) {
            return 0;
        }
        return this.iak.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bQv() {
        return this.iak;
    }
}
