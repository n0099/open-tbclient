package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideExperiments;
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
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class GlideBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GlideExecutor animationExecutor;
    public ArrayPool arrayPool;
    public BitmapPool bitmapPool;
    public ConnectivityMonitorFactory connectivityMonitorFactory;
    public List defaultRequestListeners;
    public Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    public final Map defaultTransitionOptions;
    public GlideExecutor diskCacheExecutor;
    public DiskCache.Factory diskCacheFactory;
    public Engine engine;
    public final GlideExperiments.Builder glideExperimentsBuilder;
    public boolean isActiveResourceRetentionAllowed;
    public int logLevel;
    public MemoryCache memoryCache;
    public MemorySizeCalculator memorySizeCalculator;
    public RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    public GlideExecutor sourceExecutor;

    /* loaded from: classes7.dex */
    public final class EnableImageDecoderForBitmaps implements GlideExperiments.Experiment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EnableImageDecoderForBitmaps() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class LogRequestOrigins implements GlideExperiments.Experiment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public LogRequestOrigins() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class ManualOverrideHardwareBitmapMaxFdCount implements GlideExperiments.Experiment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int fdCount;

        public ManualOverrideHardwareBitmapMaxFdCount(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fdCount = i;
        }
    }

    /* loaded from: classes7.dex */
    public final class WaitForFramesAfterTrimMemory implements GlideExperiments.Experiment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public WaitForFramesAfterTrimMemory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

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
        this.glideExperimentsBuilder = new GlideExperiments.Builder();
        this.logLevel = 4;
        this.defaultRequestOptionsFactory = new Glide.RequestOptionsFactory(this) { // from class: com.bumptech.glide.GlideBuilder.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GlideBuilder this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.bumptech.glide.Glide.RequestOptionsFactory
            public RequestOptions build() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new RequestOptions();
                }
                return (RequestOptions) invokeV.objValue;
            }
        };
    }

    public GlideBuilder addGlobalRequestListener(RequestListener requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestListener)) == null) {
            if (this.defaultRequestListeners == null) {
                this.defaultRequestListeners = new ArrayList();
            }
            this.defaultRequestListeners.add(requestListener);
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setAnimationExecutor(GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, glideExecutor)) == null) {
            this.animationExecutor = glideExecutor;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setArrayPool(ArrayPool arrayPool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayPool)) == null) {
            this.arrayPool = arrayPool;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setBitmapPool(BitmapPool bitmapPool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmapPool)) == null) {
            this.bitmapPool = bitmapPool;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setConnectivityMonitorFactory(ConnectivityMonitorFactory connectivityMonitorFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, connectivityMonitorFactory)) == null) {
            this.connectivityMonitorFactory = connectivityMonitorFactory;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setDefaultRequestOptions(Glide.RequestOptionsFactory requestOptionsFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, requestOptionsFactory)) == null) {
            this.defaultRequestOptionsFactory = (Glide.RequestOptionsFactory) Preconditions.checkNotNull(requestOptionsFactory);
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setDiskCache(DiskCache.Factory factory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, factory)) == null) {
            this.diskCacheFactory = factory;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setDiskCacheExecutor(GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, glideExecutor)) == null) {
            this.diskCacheExecutor = glideExecutor;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setEngine(Engine engine) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, engine)) == null) {
            this.engine = engine;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            GlideExperiments.Builder builder = this.glideExperimentsBuilder;
            EnableImageDecoderForBitmaps enableImageDecoderForBitmaps = new EnableImageDecoderForBitmaps();
            if (z && Build.VERSION.SDK_INT >= 29) {
                z2 = true;
            } else {
                z2 = false;
            }
            builder.update(enableImageDecoderForBitmaps, z2);
            return this;
        }
        return (GlideBuilder) invokeZ.objValue;
    }

    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            this.isActiveResourceRetentionAllowed = z;
            return this;
        }
        return (GlideBuilder) invokeZ.objValue;
    }

    public GlideBuilder setLogLevel(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (i >= 2 && i <= 6) {
                this.logLevel = i;
                return this;
            }
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        return (GlideBuilder) invokeI.objValue;
    }

    public GlideBuilder setLogRequestOrigins(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.glideExperimentsBuilder.update(new LogRequestOrigins(), z);
            return this;
        }
        return (GlideBuilder) invokeZ.objValue;
    }

    public GlideBuilder setMemoryCache(MemoryCache memoryCache) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, memoryCache)) == null) {
            this.memoryCache = memoryCache;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, builder)) == null) {
            return setMemorySizeCalculator(builder.build());
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public void setRequestManagerFactory(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, requestManagerFactory) == null) {
            this.requestManagerFactory = requestManagerFactory;
        }
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, glideExecutor)) == null) {
            return setSourceExecutor(glideExecutor);
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setSourceExecutor(GlideExecutor glideExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, glideExecutor)) == null) {
            this.sourceExecutor = glideExecutor;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public Glide build(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
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
                this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), this.animationExecutor, this.isActiveResourceRetentionAllowed);
            }
            List list = this.defaultRequestListeners;
            if (list == null) {
                this.defaultRequestListeners = Collections.emptyList();
            } else {
                this.defaultRequestListeners = Collections.unmodifiableList(list);
            }
            GlideExperiments build = this.glideExperimentsBuilder.build();
            return new Glide(context, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new RequestManagerRetriever(this.requestManagerFactory, build), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptionsFactory, this.defaultTransitionOptions, this.defaultRequestListeners, build);
        }
        return (Glide) invokeL.objValue;
    }

    public GlideBuilder setDefaultRequestOptions(RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, requestOptions)) == null) {
            return setDefaultRequestOptions(new Glide.RequestOptionsFactory(this, requestOptions) { // from class: com.bumptech.glide.GlideBuilder.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GlideBuilder this$0;
                public final /* synthetic */ RequestOptions val$requestOptions;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, requestOptions};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$requestOptions = requestOptions;
                }

                @Override // com.bumptech.glide.Glide.RequestOptionsFactory
                public RequestOptions build() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        RequestOptions requestOptions2 = this.val$requestOptions;
                        if (requestOptions2 == null) {
                            return new RequestOptions();
                        }
                        return requestOptions2;
                    }
                    return (RequestOptions) invokeV.objValue;
                }
            });
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator memorySizeCalculator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, memorySizeCalculator)) == null) {
            this.memorySizeCalculator = memorySizeCalculator;
            return this;
        }
        return (GlideBuilder) invokeL.objValue;
    }

    public GlideBuilder setDefaultTransitionOptions(Class cls, TransitionOptions transitionOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, transitionOptions)) == null) {
            this.defaultTransitionOptions.put(cls, transitionOptions);
            return this;
        }
        return (GlideBuilder) invokeLL.objValue;
    }
}
