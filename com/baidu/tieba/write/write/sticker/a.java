package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap ieF;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.ieF = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ieF, this.mMatrix, null);
        }
    }

    public int bRS() {
        if (this.ieF == null) {
            return 0;
        }
        return this.ieF.getWidth();
    }

    public int bRT() {
        if (this.ieF == null) {
            return 0;
        }
        return this.ieF.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bRU() {
        return this.ieF;
    }
}
