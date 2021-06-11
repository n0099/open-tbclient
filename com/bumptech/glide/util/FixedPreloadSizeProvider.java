package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
/* loaded from: classes6.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    public final int[] size;

    public FixedPreloadSizeProvider(int i2, int i3) {
        this.size = new int[]{i2, i3};
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @Nullable
    public int[] getPreloadSize(@NonNull T t, int i2, int i3) {
        return this.size;
    }
}
