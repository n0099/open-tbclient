package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap ohP;

    public a(Bitmap bitmap) {
        this.ohP = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ohP, this.mMatrix, null);
        }
    }

    public int ebq() {
        if (this.ohP == null) {
            return 0;
        }
        return this.ohP.getWidth();
    }

    public int ebr() {
        if (this.ohP == null) {
            return 0;
        }
        return this.ohP.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap ebs() {
        return this.ohP;
    }
}
