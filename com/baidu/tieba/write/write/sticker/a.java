package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes11.dex */
public class a {
    private Bitmap kUv;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kUv = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kUv, this.mMatrix, null);
        }
    }

    public int cVN() {
        if (this.kUv == null) {
            return 0;
        }
        return this.kUv.getWidth();
    }

    public int cVO() {
        if (this.kUv == null) {
            return 0;
        }
        return this.kUv.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cVP() {
        return this.kUv;
    }
}
