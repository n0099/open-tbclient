package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes7.dex */
public class a {
    private Matrix mMatrix = new Matrix();
    private Bitmap opH;

    public a(Bitmap bitmap) {
        this.opH = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.opH, this.mMatrix, null);
        }
    }

    public int eaa() {
        if (this.opH == null) {
            return 0;
        }
        return this.opH.getWidth();
    }

    public int eab() {
        if (this.opH == null) {
            return 0;
        }
        return this.opH.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap eac() {
        return this.opH;
    }
}
