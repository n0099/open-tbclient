package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jWh;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jWh = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jWh, this.mMatrix, null);
        }
    }

    public int cAJ() {
        if (this.jWh == null) {
            return 0;
        }
        return this.jWh.getWidth();
    }

    public int cAK() {
        if (this.jWh == null) {
            return 0;
        }
        return this.jWh.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cAL() {
        return this.jWh;
    }
}
