package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes13.dex */
public class a {
    private Bitmap kVg;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.kVg = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.kVg, this.mMatrix, null);
        }
    }

    public int cXd() {
        if (this.kVg == null) {
            return 0;
        }
        return this.kVg.getWidth();
    }

    public int cXe() {
        if (this.kVg == null) {
            return 0;
        }
        return this.kVg.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap cXf() {
        return this.kVg;
    }
}
