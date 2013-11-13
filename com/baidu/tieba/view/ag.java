package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class ag extends ImageView {
    public void a() {
        if (getBackground() != null) {
            Bitmap bitmap = ((BitmapDrawable) getBackground()).getBitmap();
            setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
