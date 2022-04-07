package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public final class GlideBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GlideExecutor animationExecutor;
    public ArrayPool arrayPool;
    public BitmapPool bitmapPool;
    public ConnectivityMonitorFactory connectivityMonitorFactory;
    public RequestOptions defaultRequestOptions;
    public final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    public GlideExecutor diskCacheExecutor;
    public DiskCache.Factory diskCacheFactory;
    public Engine engine;
    public boolean isActiveResourceRetentionAllowed;
    public int logLevel;
    public MemoryCache memoryCache;
    public MemorySizeCalculator memorySizeCalculator;
    @Nullable
    public RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    public GlideExecutor sourceExecutor;

    public GlideBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.defaultTransitionOptions = new ArrayMap();
        this.logLevel = 4;
        this.defaultRequestOptions = new RequestOptions();
    }

    @NonNull
    public Glide build(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
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
        return (Glide) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, glideExecutor)) == null) {
            this.animationExecutor = glideExecutor;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool arrayPool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayPool)) == null) {
            this.arrayPool = arrayPool;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool bitmapPool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmapPool)) == null) {
            this.bitmapPool = bitmapPool;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, connectivityMonitorFactory)) == null) {
            this.connectivityMonitorFactory = connectivityMonitorFactory;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, requestOptions)) == null) {
            this.defaultRequestOptions = requestOptions;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, cls, transitionOptions)) == null) {
            this.defaultTransitionOptions.put(cls, transitionOptions);
            return this;
        }
        return (GlideBuilder) invokeLL.objValue;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory factory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, factory)) == null) {
            this.diskCacheFactory = factory;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, glideExecutor)) == null) {
            this.diskCacheExecutor = glideExecutor;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setEngine(Engine engine) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, engine)) == null) {
            this.engine = engine;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.isActiveResourceRetentionAllowed = z;
            return this;
        }
        return (GlideBuilder) invokeZ.objValue;
    }

    @NonNull
    public GlideBuilder setLogLevel(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (i >= 2 && i <= 6) {
                this.logLevel = i;
                return this;
            }
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        return (GlideBuilder) invokeI.objValue;
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache memoryCache) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, memoryCache)) == null) {
            this.memoryCache = memoryCache;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, builder)) == null) ? setMemorySizeCalculator(builder.build()) : (GlideBuilder) invokeL.objValue;
    }

    public void setRequestManagerFactory(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, requestManagerFactory) == null) {
            this.requestManagerFactory = requestManagerFactory;
        }
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, glideExecutor)) == null) ? setSourceExecutor(glideExecutor) : (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, glideExecutor)) == null) {
            this.sourceExecutor = glideExecutor;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator memorySizeCalculator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, memorySizeCalculator)) == null) {
            this.memorySizeCalculator = memorySizeCalculator;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }
}
