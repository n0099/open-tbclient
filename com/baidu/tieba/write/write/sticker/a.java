package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jvr;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jvr = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jvr, this.mMatrix, null);
        }
    }

    public int crM() {
        if (this.jvr == null) {
            return 0;
        }
        return this.jvr.getWidth();
    }

    public int crN() {
        if (this.jvr == null) {
            return 0;
        }
        return this.jvr.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap crO() {
        return this.jvr;
    }
}
