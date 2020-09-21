package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap nhQ;

    public a(Bitmap bitmap) {
        this.nhQ = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.nhQ, this.mMatrix, null);
        }
    }

    public int dNw() {
        if (this.nhQ == null) {
            return 0;
        }
        return this.nhQ.getWidth();
    }

    public int dNx() {
        if (this.nhQ == null) {
            return 0;
        }
        return this.nhQ.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dNy() {
        return this.nhQ;
    }
}
