package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap jYZ;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.jYZ = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.jYZ, this.mMatrix, null);
        }
    }

    public int cEb() {
        if (this.jYZ == null) {
            return 0;
        }
        return this.jYZ.getWidth();
    }

    public int cEc() {
        if (this.jYZ == null) {
            return 0;
        }
        return this.jYZ.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cEd() {
        return this.jYZ;
    }
}
