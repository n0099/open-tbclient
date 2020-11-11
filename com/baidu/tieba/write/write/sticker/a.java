package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap nPH;

    public a(Bitmap bitmap) {
        this.nPH = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.nPH, this.mMatrix, null);
        }
    }

    public int dWQ() {
        if (this.nPH == null) {
            return 0;
        }
        return this.nPH.getWidth();
    }

    public int dWR() {
        if (this.nPH == null) {
            return 0;
        }
        return this.nPH.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dWS() {
        return this.nPH;
    }
}
