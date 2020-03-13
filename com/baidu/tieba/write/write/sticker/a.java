package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes13.dex */
public class a {
    private Bitmap kVu;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kVu = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kVu, this.mMatrix, null);
        }
    }

    public int cXg() {
        if (this.kVu == null) {
            return 0;
        }
        return this.kVu.getWidth();
    }

    public int cXh() {
        if (this.kVu == null) {
            return 0;
        }
        return this.kVu.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cXi() {
        return this.kVu;
    }
}
