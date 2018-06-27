package com.baidu.tieba.write.write.sticker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class a {
    private Bitmap hAw;
    private Matrix mMatrix = new Matrix();

    public a(Bitmap bitmap) {
        this.hAw = bitmap;
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(this.hAw, this.mMatrix, null);
        }
    }

    public int bJW() {
        if (this.hAw == null) {
            return 0;
        }
        return this.hAw.getWidth();
    }

    public int bJX() {
        if (this.hAw == null) {
            return 0;
        }
        return this.hAw.getHeight();
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Bitmap bJY() {
        return this.hAw;
    }
}
