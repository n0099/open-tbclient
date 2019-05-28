package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jOu;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jOu = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jOu, this.mMatrix, null);
        }
    }

    public int czV() {
        if (this.jOu == null) {
            return 0;
        }
        return this.jOu.getWidth();
    }

    public int czW() {
        if (this.jOu == null) {
            return 0;
        }
        return this.jOu.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap czX() {
        return this.jOu;
    }
}
