package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap mEy;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.mEy = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mEy, this.mMatrix, null);
        }
    }

    public int dxA() {
        if (this.mEy == null) {
            return 0;
        }
        return this.mEy.getWidth();
    }

    public int dxB() {
        if (this.mEy == null) {
            return 0;
        }
        return this.mEy.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dxC() {
        return this.mEy;
    }
}
