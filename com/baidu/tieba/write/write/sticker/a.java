package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap hNs;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hNs = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hNs, this.mMatrix, null);
        }
    }

    public int bJB() {
        if (this.hNs == null) {
            return 0;
        }
        return this.hNs.getWidth();
    }

    public int bJC() {
        if (this.hNs == null) {
            return 0;
        }
        return this.hNs.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bJD() {
        return this.hNs;
    }
}
