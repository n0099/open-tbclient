package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
/* loaded from: classes5.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    @Nullable
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this(bitmapPool, null);
    }

    public GifBitmapProvider(BitmapPool bitmapPool, @Nullable ArrayPool arrayPool) {
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public Bitmap obtain(int i, int i2, @NonNull Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@NonNull Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public byte[] obtainByteArray(int i) {
        return this.arrayPool == null ? new byte[i] : (byte[]) this.arrayPool.get(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@NonNull byte[] bArr) {
        if (this.arrayPool != null) {
            this.arrayPool.put(bArr);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public int[] obtainIntArray(int i) {
        return this.arrayPool == null ? new int[i] : (int[]) this.arrayPool.get(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@NonNull int[] iArr) {
        if (this.arrayPool != null) {
            this.arrayPool.put(iArr);
        }
    }
}
