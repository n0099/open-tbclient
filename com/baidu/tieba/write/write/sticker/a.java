package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes11.dex */
public class a {
    private Bitmap kUA;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kUA = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kUA, this.mMatrix, null);
        }
    }

    public int cVP() {
        if (this.kUA == null) {
            return 0;
        }
        return this.kUA.getWidth();
    }

    public int cVQ() {
        if (this.kUA == null) {
            return 0;
        }
        return this.kUA.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cVR() {
        return this.kUA;
    }
}
