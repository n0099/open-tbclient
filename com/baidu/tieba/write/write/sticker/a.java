package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hRp;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hRp = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hRp, this.mMatrix, null);
        }
    }

    public int bOP() {
        if (this.hRp == null) {
            return 0;
        }
        return this.hRp.getWidth();
    }

    public int bOQ() {
        if (this.hRp == null) {
            return 0;
        }
        return this.hRp.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bOR() {
        return this.hRp;
    }
}
