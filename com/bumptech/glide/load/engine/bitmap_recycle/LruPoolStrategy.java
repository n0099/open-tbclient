package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public interface LruPoolStrategy {
    @Nullable
    Bitmap get(int i2, int i3, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i2, int i3, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
