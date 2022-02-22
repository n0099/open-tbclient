package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int JOB_POOL_SIZE = 150;
    public static final String TAG = "Engine";
    public static final boolean VERBOSE_IS_LOGGABLE;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActiveResources activeResources;
    public final MemoryCache cache;
    public final DecodeJobFactory decodeJobFactory;
    public final LazyDiskCacheProvider diskCacheProvider;
    public final EngineJobFactory engineJobFactory;
    public final Jobs jobs;
    public final EngineKeyFactory keyFactory;
    public final ResourceRecycler resourceRecycler;

    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class DecodeJobFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int creationOrder;
        public final DecodeJob.DiskCacheProvider diskCacheProvider;
        public final Pools.Pool<DecodeJob<?>> pool;

        public DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskCacheProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = FactoryPools.simple(150, new FactoryPools.Factory<DecodeJob<?>>(this) { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DecodeJobFactory this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
                public DecodeJob<?> create() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        DecodeJobFactory decodeJobFactory = this.this$0;
                        return new DecodeJob<>(decodeJobFactory.diskCacheProvider, decodeJobFactory.pool);
                    }
                    return (DecodeJob) invokeV.objValue;
                }
            });
            this.diskCacheProvider = diskCacheProvider;
        }

        public <R> DecodeJob<R> build(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.Callback<R> callback) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{glideContext, obj, engineKey, key, Integer.valueOf(i2), Integer.valueOf(i3), cls, cls2, priority, diskCacheStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), options, callback})) == null) {
                DecodeJob decodeJob = (DecodeJob) Preconditions.checkNotNull(this.pool.acquire());
                int i4 = this.creationOrder;
                this.creationOrder = i4 + 1;
                return decodeJob.init(glideContext, obj, engineKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, callback, i4);
            }
            return (DecodeJob) invokeCommon.objValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class EngineJobFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GlideExecutor animationExecutor;
        public final GlideExecutor diskCacheExecutor;
        public final EngineJobListener listener;
        public final Pools.Pool<EngineJob<?>> pool;
        public final GlideExecutor sourceExecutor;
        public final GlideExecutor sourceUnlimitedExecutor;

        public EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = FactoryPools.simple(150, new FactoryPools.Factory<EngineJob<?>>(this) { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EngineJobFactory this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
                public EngineJob<?> create() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        EngineJobFactory engineJobFactory = this.this$0;
                        return new EngineJob<>(engineJobFactory.diskCacheExecutor, engineJobFactory.sourceExecutor, engineJobFactory.sourceUnlimitedExecutor, engineJobFactory.animationExecutor, engineJobFactory.listener, engineJobFactory.pool);
                    }
                    return (EngineJob) invokeV.objValue;
                }
            });
            this.diskCacheExecutor = glideExecutor;
            this.sourceExecutor = glideExecutor2;
            this.sourceUnlimitedExecutor = glideExecutor3;
            this.animationExecutor = glideExecutor4;
            this.listener = engineJobListener;
        }

        public static void shutdownAndAwaitTermination(ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, executorService) == null) {
                executorService.shutdown();
                try {
                    if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                        return;
                    }
                    executorService.shutdownNow();
                    if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                        return;
                    }
                    throw new RuntimeException("Failed to shutdown");
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        public <R> EngineJob<R> build(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{key, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? ((EngineJob) Preconditions.checkNotNull(this.pool.acquire())).init(key, z, z2, z3, z4) : (EngineJob) invokeCommon.objValue;
        }

        @VisibleForTesting
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                shutdownAndAwaitTermination(this.diskCacheExecutor);
                shutdownAndAwaitTermination(this.sourceExecutor);
                shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
                shutdownAndAwaitTermination(this.animationExecutor);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile DiskCache diskCache;
        public final DiskCache.Factory factory;

        public LazyDiskCacheProvider(DiskCache.Factory factory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {factory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.factory = factory;
        }

        @VisibleForTesting
        public synchronized void clearDiskCacheIfCreated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.diskCache == null) {
                        return;
                    }
                    this.diskCache.clear();
                }
            }
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache getDiskCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.diskCache == null) {
                    synchronized (this) {
                        if (this.diskCache == null) {
                            this.diskCache = this.factory.build();
                        }
                        if (this.diskCache == null) {
                            this.diskCache = new DiskCacheAdapter();
                        }
                    }
                }
                return this.diskCache;
            }
            return (DiskCache) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class LoadStatus {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceCallback cb;
        public final EngineJob<?> engineJob;

        public LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resourceCallback, engineJob};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cb = resourceCallback;
            this.engineJob = engineJob;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.engineJob.removeCallback(this.cb);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(308351298, "Lcom/bumptech/glide/load/engine/Engine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(308351298, "Lcom/bumptech/glide/load/engine/Engine;");
                return;
            }
        }
        VERBOSE_IS_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MemoryCache) objArr2[0], (DiskCache.Factory) objArr2[1], (GlideExecutor) objArr2[2], (GlideExecutor) objArr2[3], (GlideExecutor) objArr2[4], (GlideExecutor) objArr2[5], (Jobs) objArr2[6], (EngineKeyFactory) objArr2[7], (ActiveResources) objArr2[8], (EngineJobFactory) objArr2[9], (DecodeJobFactory) objArr2[10], (ResourceRecycler) objArr2[11], ((Boolean) objArr2[12]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private EngineResource<?> getEngineResourceFromCache(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, key)) == null) {
            Resource<?> remove = this.cache.remove(key);
            if (remove == null) {
                return null;
            }
            if (remove instanceof EngineResource) {
                return (EngineResource) remove;
            }
            return new EngineResource<>(remove, true, true);
        }
        return (EngineResource) invokeL.objValue;
    }

    @Nullable
    private EngineResource<?> loadFromActiveResources(Key key, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, key, z)) == null) {
            if (z) {
                EngineResource<?> engineResource = this.activeResources.get(key);
                if (engineResource != null) {
                    engineResource.acquire();
                }
                return engineResource;
            }
            return null;
        }
        return (EngineResource) invokeLZ.objValue;
    }

    private EngineResource<?> loadFromCache(Key key, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, this, key, z)) == null) {
            if (z) {
                EngineResource<?> engineResourceFromCache = getEngineResourceFromCache(key);
                if (engineResourceFromCache != null) {
                    engineResourceFromCache.acquire();
                    this.activeResources.activate(key, engineResourceFromCache);
                }
                return engineResourceFromCache;
            }
            return null;
        }
        return (EngineResource) invokeLZ.objValue;
    }

    public static void logWithTimeAndKey(String str, long j2, Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Long.valueOf(j2), key}) == null) {
            String str2 = str + " in " + LogTime.getElapsedMillis(j2) + "ms, key: " + key;
        }
    }

    public void clearDiskCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.diskCacheProvider.getDiskCache().clear();
        }
    }

    public <R> LoadStatus load(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideContext, obj, key, Integer.valueOf(i2), Integer.valueOf(i3), cls, cls2, priority, diskCacheStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), options, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), resourceCallback})) == null) {
            Util.assertMainThread();
            long logTime = VERBOSE_IS_LOGGABLE ? LogTime.getLogTime() : 0L;
            EngineKey buildKey = this.keyFactory.buildKey(obj, key, i2, i3, map, cls, cls2, options);
            EngineResource<?> loadFromActiveResources = loadFromActiveResources(buildKey, z3);
            if (loadFromActiveResources != null) {
                resourceCallback.onResourceReady(loadFromActiveResources, DataSource.MEMORY_CACHE);
                if (VERBOSE_IS_LOGGABLE) {
                    logWithTimeAndKey("Loaded resource from active resources", logTime, buildKey);
                }
                return null;
            }
            EngineResource<?> loadFromCache = loadFromCache(buildKey, z3);
            if (loadFromCache != null) {
                resourceCallback.onResourceReady(loadFromCache, DataSource.MEMORY_CACHE);
                if (VERBOSE_IS_LOGGABLE) {
                    logWithTimeAndKey("Loaded resource from cache", logTime, buildKey);
                }
                return null;
            }
            EngineJob<?> engineJob = this.jobs.get(buildKey, z6);
            if (engineJob != null) {
                engineJob.addCallback(resourceCallback);
                if (VERBOSE_IS_LOGGABLE) {
                    logWithTimeAndKey("Added to existing load", logTime, buildKey);
                }
                return new LoadStatus(resourceCallback, engineJob);
            }
            EngineJob<R> build = this.engineJobFactory.build(buildKey, z3, z4, z5, z6);
            DecodeJob<R> build2 = this.decodeJobFactory.build(glideContext, obj, buildKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, build);
            this.jobs.put(buildKey, build);
            build.addCallback(resourceCallback);
            build.start(build2);
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Started new load", logTime, buildKey);
            }
            return new LoadStatus(resourceCallback, build);
        }
        return (LoadStatus) invokeCommon.objValue;
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public void onEngineJobCancelled(EngineJob<?> engineJob, Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, engineJob, key) == null) {
            Util.assertMainThread();
            this.jobs.removeIfCurrent(key, engineJob);
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, engineJob, key, engineResource) == null) {
            Util.assertMainThread();
            if (engineResource != null) {
                engineResource.setResourceListener(key, this);
                if (engineResource.isCacheable()) {
                    this.activeResources.activate(key, engineResource);
                }
            }
            this.jobs.removeIfCurrent(key, engineJob);
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void onResourceReleased(Key key, EngineResource<?> engineResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, key, engineResource) == null) {
            Util.assertMainThread();
            this.activeResources.deactivate(key);
            if (engineResource.isCacheable()) {
                this.cache.put(key, engineResource);
            } else {
                this.resourceRecycler.recycle(engineResource);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(@NonNull Resource<?> resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, resource) == null) {
            Util.assertMainThread();
            this.resourceRecycler.recycle(resource);
        }
    }

    public void release(Resource<?> resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resource) == null) {
            Util.assertMainThread();
            if (resource instanceof EngineResource) {
                ((EngineResource) resource).release();
                return;
            }
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
    }

    @VisibleForTesting
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.engineJobFactory.shutdown();
            this.diskCacheProvider.clearDiskCacheIfCreated();
            this.activeResources.shutdown();
        }
    }

    @VisibleForTesting
    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, jobs, engineKeyFactory, activeResources, engineJobFactory, decodeJobFactory, resourceRecycler, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = memoryCache;
        this.diskCacheProvider = new LazyDiskCacheProvider(factory);
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.activeResources = activeResources2;
        activeResources2.setListener(this);
        this.keyFactory = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.jobs = jobs == null ? new Jobs() : jobs;
        this.engineJobFactory = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this) : engineJobFactory;
        this.decodeJobFactory = decodeJobFactory == null ? new DecodeJobFactory(this.diskCacheProvider) : decodeJobFactory;
        this.resourceRecycler = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.setResourceRemovedListener(this);
    }
}
