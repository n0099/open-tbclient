package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private Bitmap kQU;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kQU = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kQU, this.mMatrix, null);
        }
    }

    public int cUK() {
        if (this.kQU == null) {
            return 0;
        }
        return this.kQU.getWidth();
    }

    public int cUL() {
        if (this.kQU == null) {
            return 0;
        }
        return this.kQU.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cUM() {
        return this.kQU;
    }
}
