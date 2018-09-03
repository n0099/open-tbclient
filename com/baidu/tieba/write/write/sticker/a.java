package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hBG;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hBG = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hBG, this.mMatrix, null);
        }
    }

    public int bIN() {
        if (this.hBG == null) {
            return 0;
        }
        return this.hBG.getWidth();
    }

    public int bIO() {
        if (this.hBG == null) {
            return 0;
        }
        return this.hBG.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bIP() {
        return this.hBG;
    }
}
