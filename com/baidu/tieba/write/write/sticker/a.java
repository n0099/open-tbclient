package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap mEA;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.mEA = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mEA, this.mMatrix, null);
        }
    }

    public int dxB() {
        if (this.mEA == null) {
            return 0;
        }
        return this.mEA.getWidth();
    }

    public int dxC() {
        if (this.mEA == null) {
            return 0;
        }
        return this.mEA.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dxD() {
        return this.mEA;
    }
}
