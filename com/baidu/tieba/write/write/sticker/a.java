package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap lGY;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.lGY = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.lGY, this.mMatrix, null);
        }
    }

    public int dim() {
        if (this.lGY == null) {
            return 0;
        }
        return this.lGY.getWidth();
    }

    public int din() {
        if (this.lGY == null) {
            return 0;
        }
        return this.lGY.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dio() {
        return this.lGY;
    }
}
