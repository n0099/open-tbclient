package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap mwu;

    public a(Bitmap bitmap) {
        this.mwu = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.mwu, this.mMatrix, null);
        }
    }

    public int duo() {
        if (this.mwu == null) {
            return 0;
        }
        return this.mwu.getWidth();
    }

    public int dup() {
        if (this.mwu == null) {
            return 0;
        }
        return this.mwu.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap duq() {
        return this.mwu;
    }
}
