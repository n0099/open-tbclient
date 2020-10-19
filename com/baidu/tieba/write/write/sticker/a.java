package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap nxp;

    public a(Bitmap bitmap) {
        this.nxp = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.nxp, this.mMatrix, null);
        }
    }

    public int dRi() {
        if (this.nxp == null) {
            return 0;
        }
        return this.nxp.getWidth();
    }

    public int dRj() {
        if (this.nxp == null) {
            return 0;
        }
        return this.nxp.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap dRk() {
        return this.nxp;
    }
}
