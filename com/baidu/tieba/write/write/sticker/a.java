package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jvI;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jvI = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jvI, this.mMatrix, null);
        }
    }

    public int crL() {
        if (this.jvI == null) {
            return 0;
        }
        return this.jvI.getWidth();
    }

    public int crM() {
        if (this.jvI == null) {
            return 0;
        }
        return this.jvI.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap crN() {
        return this.jvI;
    }
}
