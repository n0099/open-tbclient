package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes13.dex */
public class a {
    private Bitmap kVi;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kVi = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kVi, this.mMatrix, null);
        }
    }

    public int cXf() {
        if (this.kVi == null) {
            return 0;
        }
        return this.kVi.getWidth();
    }

    public int cXg() {
        if (this.kVi == null) {
            return 0;
        }
        return this.kVi.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cXh() {
        return this.kVi;
    }
}
