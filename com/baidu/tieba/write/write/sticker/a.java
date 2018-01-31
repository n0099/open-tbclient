package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap hLT;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hLT = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hLT, this.mMatrix, null);
        }
    }

    public int bIO() {
        if (this.hLT == null) {
            return 0;
        }
        return this.hLT.getWidth();
    }

    public int bIP() {
        if (this.hLT == null) {
            return 0;
        }
        return this.hLT.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bIQ() {
        return this.hLT;
    }
}
