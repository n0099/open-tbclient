package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hTa;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hTa = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hTa, this.mMatrix, null);
        }
    }

    public int bOo() {
        if (this.hTa == null) {
            return 0;
        }
        return this.hTa.getWidth();
    }

    public int bOp() {
        if (this.hTa == null) {
            return 0;
        }
        return this.hTa.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bOq() {
        return this.hTa;
    }
}
