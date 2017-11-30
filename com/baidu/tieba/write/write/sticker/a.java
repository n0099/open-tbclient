package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap gsL;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.gsL = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.gsL, this.mMatrix, null);
        }
    }

    public int btn() {
        if (this.gsL == null) {
            return 0;
        }
        return this.gsL.getWidth();
    }

    public int bto() {
        if (this.gsL == null) {
            return 0;
        }
        return this.gsL.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap btp() {
        return this.gsL;
    }
}
