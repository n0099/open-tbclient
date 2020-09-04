package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap mXS;

    public a(Bitmap bitmap) {
        this.mXS = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mXS, this.mMatrix, null);
        }
    }

    public int dJy() {
        if (this.mXS == null) {
            return 0;
        }
        return this.mXS.getWidth();
    }

    public int dJz() {
        if (this.mXS == null) {
            return 0;
        }
        return this.mXS.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dJA() {
        return this.mXS;
    }
}
