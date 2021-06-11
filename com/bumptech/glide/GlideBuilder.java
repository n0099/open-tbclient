package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;
/* loaded from: classes6.dex */
public final class GlideBuilder {
    public GlideExecutor animationExecutor;
    public ArrayPool arrayPool;
    public BitmapPool bitmapPool;
    public ConnectivityMonitorFactory connectivityMonitorFactory;
    public GlideExecutor diskCacheExecutor;
    public DiskCache.Factory diskCacheFactory;
    public Engine engine;
    public boolean isActiveResourceRetentionAllowed;
    public MemoryCache memoryCache;
    public MemorySizeCalculator memorySizeCalculator;
    @Nullable
    public RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    public GlideExecutor sourceExecutor;
    public final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions = new ArrayMap();
    public int logLevel = 4;
    public RequestOptions defaultRequestOptions = new RequestOptions();

    @NonNull
    public Glide build(@NonNull Context context) {
        if (this.sourceExecutor == null) {
            this.sourceExecutor = GlideExecutor.newSourceExecutor();
        }
        if (this.diskCacheExecutor == null) {
            this.diskCacheExecutor = GlideExecutor.newDiskCacheExecutor();
        }
        if (this.animationExecutor == null) {
            this.animationExecutor = GlideExecutor.newAnimationExecutor();
        }
        if (this.memorySizeCalculator == null) {
            this.memorySizeCalculator = new MemorySizeCalculator.Builder(context).build();
        }
        if (this.connectivityMonitorFactory == null) {
            this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
        }
        if (this.bitmapPool == null) {
            int bitmapPoolSize = this.memorySizeCalculator.getBitmapPoolSize();
            if (bitmapPoolSize > 0) {
                this.bitmapPool = new LruBitmapPool(bitmapPoolSize);
            } else {
                this.bitmapPool = new BitmapPoolAdapter();
            }
        }
        if (this.arrayPool == null) {
            this.arrayPool = new LruArrayPool(this.memorySizeCalculator.getArrayPoolSizeInBytes());
        }
        if (this.memoryCache == null) {
            this.memoryCache = new LruResourceCache(this.memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new InternalCacheDiskCacheFactory(context);
        }
        if (this.engine == null) {
            this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), GlideExecutor.newAnimationExecutor(), this.isActiveResourceRetentionAllowed);
        }
        return new Glide(context, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new RequestManagerRetriever(this.requestManagerFactory), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptions.lock(), this.defaultTransitionOptions);
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor glideExecutor) {
        this.animationExecutor = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
        return this;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions requestOptions) {
        this.defaultRequestOptions = requestOptions;
        return this;
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.defaultTransitionOptions.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory factory) {
        this.diskCacheFactory = factory;
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor glideExecutor) {
        this.diskCacheExecutor = glideExecutor;
        return this;
    }

    public GlideBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.isActiveResourceRetentionAllowed = z;
        return this;
    }

    @NonNull
    public GlideBuilder setLogLevel(int i2) {
        if (i2 >= 2 && i2 <= 6) {
            this.logLevel = i2;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder builder) {
        return setMemorySizeCalculator(builder.build());
    }

    public void setRequestManagerFactory(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.requestManagerFactory = requestManagerFactory;
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor glideExecutor) {
        this.sourceExecutor = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.memorySizeCalculator = memorySizeCalculator;
        return this;
    }
}
