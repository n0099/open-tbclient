package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class LruBitmapPool implements BitmapPool {
    public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    public static final String TAG = "LruBitmapPool";
    public final Set<Bitmap.Config> allowedConfigs;
    public long currentSize;
    public int evictions;
    public int hits;
    public final long initialMaxSize;
    public long maxSize;
    public int misses;
    public int puts;
    public final LruPoolStrategy strategy;
    public final BitmapTracker tracker;

    /* loaded from: classes7.dex */
    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public static final class NullBitmapTracker implements BitmapTracker {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static LruPoolStrategy getDefaultStrategy() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        trimToSize(0L);
    }

    public long evictionCount() {
        return this.evictions;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    public long hitCount() {
        return this.hits;
    }

    public long missCount() {
        return this.misses;
    }

    /* loaded from: classes7.dex */
    public static class ThrowingBitmapTracker implements BitmapTracker {
        public final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + PreferencesUtil.RIGHT_MOUNT);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(long j) {
        this(j, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    @TargetApi(26)
    public static void assertNotHardwareConfig(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @TargetApi(19)
    public static void maybeSetPreMultiplied(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = Math.round(((float) this.initialMaxSize) * f);
        evict();
    }

    public LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = j;
        this.maxSize = j;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    @NonNull
    public static Bitmap createBitmap(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull != null) {
            dirtyOrNull.eraseColor(0);
            return dirtyOrNull;
        }
        return createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull == null) {
            return createBitmap(i, i2, config);
        }
        return dirtyOrNull;
    }

    public LruBitmapPool(long j, Set<Bitmap.Config> set) {
        this(j, getDefaultStrategy(), set);
    }

    private void dumpUnchecked() {
        Log.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        assertNotHardwareConfig(config);
        LruPoolStrategy lruPoolStrategy = this.strategy;
        if (config != null) {
            config2 = config;
        } else {
            config2 = DEFAULT_CONFIG;
        }
        bitmap = lruPoolStrategy.get(i, i2, config2);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(i, i2, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            normalize(bitmap);
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Get bitmap=" + this.strategy.logBitmap(i, i2, config));
        }
        dump();
        return bitmap;
    }

    private synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Size mismatch, resetting");
                    dumpUnchecked();
                }
                this.currentSize = 0L;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= this.strategy.getSize(removeLast);
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(removeLast));
            }
            dump();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                        int size = this.strategy.getSize(bitmap);
                        this.strategy.put(bitmap);
                        this.tracker.add(bitmap);
                        this.puts++;
                        this.currentSize += size;
                        if (Log.isLoggable(TAG, 2)) {
                            Log.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(bitmap));
                        }
                        dump();
                        evict();
                        return;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "trimMemory, level=" + i);
        }
        if (i < 40 && (Build.VERSION.SDK_INT < 23 || i < 20)) {
            if (i >= 20 || i == 15) {
                trimToSize(getMaxSize() / 2);
                return;
            }
            return;
        }
        clearMemory();
    }
}
