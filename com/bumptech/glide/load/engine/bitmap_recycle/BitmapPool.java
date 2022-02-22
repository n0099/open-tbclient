package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface BitmapPool {
    void clearMemory();

    @NonNull
    Bitmap get(int i2, int i3, Bitmap.Config config);

    @NonNull
    Bitmap getDirty(int i2, int i3, Bitmap.Config config);

    long getMaxSize();

    void put(Bitmap bitmap);

    void setSizeMultiplier(float f2);

    void trimMemory(int i2);
}
