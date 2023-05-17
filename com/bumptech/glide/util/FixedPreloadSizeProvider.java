package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
/* loaded from: classes8.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    public final int[] size;

    public FixedPreloadSizeProvider(int i, int i2) {
        this.size = new int[]{i, i2};
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @Nullable
    public int[] getPreloadSize(@NonNull T t, int i, int i2) {
        return this.size;
    }
}
