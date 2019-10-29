package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jWY;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jWY = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jWY, this.mMatrix, null);
        }
    }

    public int cAL() {
        if (this.jWY == null) {
            return 0;
        }
        return this.jWY.getWidth();
    }

    public int cAM() {
        if (this.jWY == null) {
            return 0;
        }
        return this.jWY.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cAN() {
        return this.jWY;
    }
}
