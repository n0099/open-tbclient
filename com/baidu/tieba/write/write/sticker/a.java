package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jvq;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jvq = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jvq, this.mMatrix, null);
        }
    }

    public int crM() {
        if (this.jvq == null) {
            return 0;
        }
        return this.jvq.getWidth();
    }

    public int crN() {
        if (this.jvq == null) {
            return 0;
        }
        return this.jvq.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap crO() {
        return this.jvq;
    }
}
