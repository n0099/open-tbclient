package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jOt;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jOt = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jOt, this.mMatrix, null);
        }
    }

    public int czT() {
        if (this.jOt == null) {
            return 0;
        }
        return this.jOt.getWidth();
    }

    public int czU() {
        if (this.jOt == null) {
            return 0;
        }
        return this.jOt.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap czV() {
        return this.jOt;
    }
}
