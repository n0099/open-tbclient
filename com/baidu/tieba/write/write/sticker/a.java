package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jvp;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jvp = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jvp, this.mMatrix, null);
        }
    }

    public int crB() {
        if (this.jvp == null) {
            return 0;
        }
        return this.jvp.getWidth();
    }

    public int crC() {
        if (this.jvp == null) {
            return 0;
        }
        return this.jvp.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap crD() {
        return this.jvp;
    }
}
