package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class l extends BitmapDrawable {
    public l(Bitmap bitmap) {
        super(bitmap);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, getPaint());
        }
    }
}
