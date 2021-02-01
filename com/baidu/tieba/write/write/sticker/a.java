package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap ona;

    public a(Bitmap bitmap) {
        this.ona = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ona, this.mMatrix, null);
        }
    }

    public int dZK() {
        if (this.ona == null) {
            return 0;
        }
        return this.ona.getWidth();
    }

    public int dZL() {
        if (this.ona == null) {
            return 0;
        }
        return this.ona.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dZM() {
        return this.ona;
    }
}
