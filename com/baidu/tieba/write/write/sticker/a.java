package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap gvs;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.gvs = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.gvs, this.mMatrix, null);
        }
    }

    public int btT() {
        if (this.gvs == null) {
            return 0;
        }
        return this.gvs.getWidth();
    }

    public int btU() {
        if (this.gvs == null) {
            return 0;
        }
        return this.gvs.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap btV() {
        return this.gvs;
    }
}
