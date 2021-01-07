package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap ohO;

    public a(Bitmap bitmap) {
        this.ohO = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.ohO, this.mMatrix, null);
        }
    }

    public int ebr() {
        if (this.ohO == null) {
            return 0;
        }
        return this.ohO.getWidth();
    }

    public int ebs() {
        if (this.ohO == null) {
            return 0;
        }
        return this.ohO.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap ebt() {
        return this.ohO;
    }
}
