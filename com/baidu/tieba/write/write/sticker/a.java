package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap nRk;

    public a(Bitmap bitmap) {
        this.nRk = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.nRk, this.mMatrix, null);
        }
    }

    public int dWP() {
        if (this.nRk == null) {
            return 0;
        }
        return this.nRk.getWidth();
    }

    public int dWQ() {
        if (this.nRk == null) {
            return 0;
        }
        return this.nRk.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dWR() {
        return this.nRk;
    }
}
