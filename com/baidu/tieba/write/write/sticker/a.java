package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap onB;

    public a(Bitmap bitmap) {
        this.onB = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.onB, this.mMatrix, null);
        }
    }

    public int dZS() {
        if (this.onB == null) {
            return 0;
        }
        return this.onB.getWidth();
    }

    public int dZT() {
        if (this.onB == null) {
            return 0;
        }
        return this.onB.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dZU() {
        return this.onB;
    }
}
