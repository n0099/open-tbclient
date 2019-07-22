package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jVw;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jVw = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jVw, this.mMatrix, null);
        }
    }

    public int cCS() {
        if (this.jVw == null) {
            return 0;
        }
        return this.jVw.getWidth();
    }

    public int cCT() {
        if (this.jVw == null) {
            return 0;
        }
        return this.jVw.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cCU() {
        return this.jVw;
    }
}
