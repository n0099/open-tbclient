package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public final class bb extends ImageView {
    public final void a() {
        if (getBackground() != null) {
            Bitmap bitmap = ((BitmapDrawable) getBackground()).getBitmap();
            setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
