package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap gvx;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.gvx = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.gvx, this.mMatrix, null);
        }
    }

    public int btT() {
        if (this.gvx == null) {
            return 0;
        }
        return this.gvx.getWidth();
    }

    public int btU() {
        if (this.gvx == null) {
            return 0;
        }
        return this.gvx.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap btV() {
        return this.gvx;
    }
}
