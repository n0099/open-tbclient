package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap lHc;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.lHc = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.lHc, this.mMatrix, null);
        }
    }

    public int dik() {
        if (this.lHc == null) {
            return 0;
        }
        return this.lHc.getWidth();
    }

    public int dil() {
        if (this.lHc == null) {
            return 0;
        }
        return this.lHc.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dim() {
        return this.lHc;
    }
}
