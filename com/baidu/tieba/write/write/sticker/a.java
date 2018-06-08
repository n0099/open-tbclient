package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hwn;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hwn = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hwn, this.mMatrix, null);
        }
    }

    public int bJv() {
        if (this.hwn == null) {
            return 0;
        }
        return this.hwn.getWidth();
    }

    public int bJw() {
        if (this.hwn == null) {
            return 0;
        }
        return this.hwn.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bJx() {
        return this.hwn;
    }
}
