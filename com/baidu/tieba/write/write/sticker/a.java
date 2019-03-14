package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jvA;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jvA = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jvA, this.mMatrix, null);
        }
    }

    public int crO() {
        if (this.jvA == null) {
            return 0;
        }
        return this.jvA.getWidth();
    }

    public int crP() {
        if (this.jvA == null) {
            return 0;
        }
        return this.jvA.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap crQ() {
        return this.jvA;
    }
}
