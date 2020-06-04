package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap mbD;

    public a(Bitmap bitmap) {
        this.mbD = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mbD, this.mMatrix, null);
        }
    }

    public int dpP() {
        if (this.mbD == null) {
            return 0;
        }
        return this.mbD.getWidth();
    }

    public int dpQ() {
        if (this.mbD == null) {
            return 0;
        }
        return this.mbD.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dpR() {
        return this.mbD;
    }
}
