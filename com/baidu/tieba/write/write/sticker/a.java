package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class a {
    private Bitmap hVP;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hVP = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hVP, this.mMatrix, null);
        }
    }

    public int bPj() {
        if (this.hVP == null) {
            return 0;
        }
        return this.hVP.getWidth();
    }

    public int bPk() {
        if (this.hVP == null) {
            return 0;
        }
        return this.hVP.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bPl() {
        return this.hVP;
    }
}
