package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap idx;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.idx = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.idx, this.mMatrix, null);
        }
    }

    public int bRk() {
        if (this.idx == null) {
            return 0;
        }
        return this.idx.getWidth();
    }

    public int bRl() {
        if (this.idx == null) {
            return 0;
        }
        return this.idx.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bRm() {
        return this.idx;
    }
}
