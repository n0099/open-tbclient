package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap nJN;

    public a(Bitmap bitmap) {
        this.nJN = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.nJN, this.mMatrix, null);
        }
    }

    public int dUq() {
        if (this.nJN == null) {
            return 0;
        }
        return this.nJN.getWidth();
    }

    public int dUr() {
        if (this.nJN == null) {
            return 0;
        }
        return this.nJN.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dUs() {
        return this.nJN;
    }
}
