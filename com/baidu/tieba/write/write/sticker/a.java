package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jWC;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jWC = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jWC, this.mMatrix, null);
        }
    }

    public int cDn() {
        if (this.jWC == null) {
            return 0;
        }
        return this.jWC.getWidth();
    }

    public int cDo() {
        if (this.jWC == null) {
            return 0;
        }
        return this.jWC.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cDp() {
        return this.jWC;
    }
}
