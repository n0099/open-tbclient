package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap hLz;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hLz = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hLz, this.mMatrix, null);
        }
    }

    public int bIM() {
        if (this.hLz == null) {
            return 0;
        }
        return this.hLz.getWidth();
    }

    public int bIN() {
        if (this.hLz == null) {
            return 0;
        }
        return this.hLz.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bIO() {
        return this.hLz;
    }
}
