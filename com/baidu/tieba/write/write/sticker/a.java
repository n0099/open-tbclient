package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap mXA;

    public a(Bitmap bitmap) {
        this.mXA = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mXA, this.mMatrix, null);
        }
    }

    public int dJp() {
        if (this.mXA == null) {
            return 0;
        }
        return this.mXA.getWidth();
    }

    public int dJq() {
        if (this.mXA == null) {
            return 0;
        }
        return this.mXA.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dJr() {
        return this.mXA;
    }
}
