package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap ieE;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.ieE = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ieE, this.mMatrix, null);
        }
    }

    public int bRS() {
        if (this.ieE == null) {
            return 0;
        }
        return this.ieE.getWidth();
    }

    public int bRT() {
        if (this.ieE == null) {
            return 0;
        }
        return this.ieE.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bRU() {
        return this.ieE;
    }
}
