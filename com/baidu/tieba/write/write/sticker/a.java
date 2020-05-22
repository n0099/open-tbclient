package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap mas;

    public a(Bitmap bitmap) {
        this.mas = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mas, this.mMatrix, null);
        }
    }

    public int dpB() {
        if (this.mas == null) {
            return 0;
        }
        return this.mas.getWidth();
    }

    public int dpC() {
        if (this.mas == null) {
            return 0;
        }
        return this.mas.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dpD() {
        return this.mas;
    }
}
