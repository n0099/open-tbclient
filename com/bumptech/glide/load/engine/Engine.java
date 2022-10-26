package com.bumptech.glide.load.engine;

import android.util.Log;
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
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class DecodeJobFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int creationOrder;
        public final DecodeJob.DiskCacheProvider diskCacheProvider;
        public final Pools.Pool pool;

        public DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskCacheProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = FactoryPools.threadSafe(150, new FactoryPools.Factory(this) { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
                public DecodeJob create() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        DecodeJobFactory decodeJobFactory = this.this$0;
                        return new DecodeJob(decodeJobFactory.diskCacheProvider, decodeJobFactory.pool);
                    }
                    return (DecodeJob) invokeV.objValue;
                }
            });
            this.diskCacheProvider = diskCacheProvider;
        }

        public DecodeJob build(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.Callback callback) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{glideContext, obj, engineKey, key, Integer.valueOf(i), Integer.valueOf(i2), cls, cls2, priority, diskCacheStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), options, callback})) == null) {
                DecodeJob decodeJob = (DecodeJob) Preconditions.checkNotNull((DecodeJob) this.pool.acquire());
                int i3 = this.creationOrder;
                this.creationOrder = i3 + 1;
                return decodeJob.init(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, callback, i3);
            }
            return (DecodeJob) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class EngineJobFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GlideExecutor animationExecutor;
        public final GlideExecutor diskCacheExecutor;
        public final EngineJobListener engineJobListener;
        public final Pools.Pool pool;
        public final EngineResource.ResourceListener resourceListener;
        public final GlideExecutor sourceExecutor;
        public final GlideExecutor sourceUnlimitedExecutor;

        public EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = FactoryPools.threadSafe(150, new FactoryPools.Factory(this) { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
                public EngineJob create() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        EngineJobFactory engineJobFactory = this.this$0;
                        return new EngineJob(engineJobFactory.diskCacheExecutor, engineJobFactory.sourceExecutor, engineJobFactory.sourceUnlimitedExecutor, engineJobFactory.animationExecutor, engineJobFactory.engineJobListener, engineJobFactory.resourceListener, engineJobFactory.pool);
                    }
                    return (EngineJob) invokeV.objValue;
                }
            });
            this.diskCacheExecutor = glideExecutor;
            this.sourceExecutor = glideExecutor2;
            this.sourceUnlimitedExecutor = glideExecutor3;
            this.animationExecutor = glideExecutor4;
            this.engineJobListener = engineJobListener;
            this.resourceListener = resourceListener;
        }

        public EngineJob build(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{key, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
                return ((EngineJob) Preconditions.checkNotNull((EngineJob) this.pool.acquire())).init(key, z, z2, z3, z4);
            }
            return (EngineJob) invokeCommon.objValue;
        }

        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Executors.shutdownAndAwaitTermination(this.diskCacheExecutor);
                Executors.shutdownAndAwaitTermination(this.sourceExecutor);
                Executors.shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
                Executors.shutdownAndAwaitTermination(this.animationExecutor);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.factory = factory;
        }

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

    /* loaded from: classes7.dex */
    public class LoadStatus {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceCallback cb;
        public final EngineJob engineJob;
        public final /* synthetic */ Engine this$0;

        public LoadStatus(Engine engine, ResourceCallback resourceCallback, EngineJob engineJob) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {engine, resourceCallback, engineJob};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = engine;
            this.cb = resourceCallback;
            this.engineJob = engineJob;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0) {
                    this.engineJob.removeCallback(this.cb);
                }
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

    public void clearDiskCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.diskCacheProvider.getDiskCache().clear();
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.engineJobFactory.shutdown();
            this.diskCacheProvider.clearDiskCacheIfCreated();
            this.activeResources.shutdown();
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z) {
        ActiveResources activeResources2;
        EngineKeyFactory engineKeyFactory2;
        Jobs jobs2;
        EngineJobFactory engineJobFactory2;
        DecodeJobFactory decodeJobFactory2;
        ResourceRecycler resourceRecycler2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, jobs, engineKeyFactory, activeResources, engineJobFactory, decodeJobFactory, resourceRecycler, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = memoryCache;
        this.diskCacheProvider = new LazyDiskCacheProvider(factory);
        if (activeResources == null) {
            activeResources2 = new ActiveResources(z);
        } else {
            activeResources2 = activeResources;
        }
        this.activeResources = activeResources2;
        activeResources2.setListener(this);
        if (engineKeyFactory == null) {
            engineKeyFactory2 = new EngineKeyFactory();
        } else {
            engineKeyFactory2 = engineKeyFactory;
        }
        this.keyFactory = engineKeyFactory2;
        if (jobs == null) {
            jobs2 = new Jobs();
        } else {
            jobs2 = jobs;
        }
        this.jobs = jobs2;
        if (engineJobFactory == null) {
            engineJobFactory2 = new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this);
        } else {
            engineJobFactory2 = engineJobFactory;
        }
        this.engineJobFactory = engineJobFactory2;
        if (decodeJobFactory == null) {
            decodeJobFactory2 = new DecodeJobFactory(this.diskCacheProvider);
        } else {
            decodeJobFactory2 = decodeJobFactory;
        }
        this.decodeJobFactory = decodeJobFactory2;
        if (resourceRecycler == null) {
            resourceRecycler2 = new ResourceRecycler();
        } else {
            resourceRecycler2 = resourceRecycler;
        }
        this.resourceRecycler = resourceRecycler2;
        memoryCache.setResourceRemovedListener(this);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MemoryCache) objArr2[0], (DiskCache.Factory) objArr2[1], (GlideExecutor) objArr2[2], (GlideExecutor) objArr2[3], (GlideExecutor) objArr2[4], (GlideExecutor) objArr2[5], (Jobs) objArr2[6], (EngineKeyFactory) objArr2[7], (ActiveResources) objArr2[8], (EngineJobFactory) objArr2[9], (DecodeJobFactory) objArr2[10], (ResourceRecycler) objArr2[11], ((Boolean) objArr2[12]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private EngineResource getEngineResourceFromCache(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, key)) == null) {
            Resource remove = this.cache.remove(key);
            if (remove == null) {
                return null;
            }
            if (remove instanceof EngineResource) {
                return (EngineResource) remove;
            }
            return new EngineResource(remove, true, true, key, this);
        }
        return (EngineResource) invokeL.objValue;
    }

    private EngineResource loadFromActiveResources(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, key)) == null) {
            EngineResource engineResource = this.activeResources.get(key);
            if (engineResource != null) {
                engineResource.acquire();
            }
            return engineResource;
        }
        return (EngineResource) invokeL.objValue;
    }

    private EngineResource loadFromCache(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, key)) == null) {
            EngineResource engineResourceFromCache = getEngineResourceFromCache(key);
            if (engineResourceFromCache != null) {
                engineResourceFromCache.acquire();
                this.activeResources.activate(key, engineResourceFromCache);
            }
            return engineResourceFromCache;
        }
        return (EngineResource) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(Resource resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, resource) == null) {
            this.resourceRecycler.recycle(resource, true);
        }
    }

    public void release(Resource resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resource) == null) {
            if (resource instanceof EngineResource) {
                ((EngineResource) resource).release();
                return;
            }
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
    }

    private EngineResource loadFromMemory(EngineKey engineKey, boolean z, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{engineKey, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            if (!z) {
                return null;
            }
            EngineResource loadFromActiveResources = loadFromActiveResources(engineKey);
            if (loadFromActiveResources != null) {
                if (VERBOSE_IS_LOGGABLE) {
                    logWithTimeAndKey("Loaded resource from active resources", j, engineKey);
                }
                return loadFromActiveResources;
            }
            EngineResource loadFromCache = loadFromCache(engineKey);
            if (loadFromCache == null) {
                return null;
            }
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Loaded resource from cache", j, engineKey);
            }
            return loadFromCache;
        }
        return (EngineResource) invokeCommon.objValue;
    }

    public static void logWithTimeAndKey(String str, long j, Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j), key}) == null) {
            Log.v(TAG, str + " in " + LogTime.getElapsedMillis(j) + "ms, key: " + key);
        }
    }

    private LoadStatus waitForExistingOrStartNewJob(GlideContext glideContext, Object obj, Key key, int i, int i2, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{glideContext, obj, key, Integer.valueOf(i), Integer.valueOf(i2), cls, cls2, priority, diskCacheStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), options, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), resourceCallback, executor, engineKey, Long.valueOf(j)})) == null) {
            EngineJob engineJob = this.jobs.get(engineKey, z6);
            if (engineJob != null) {
                engineJob.addCallback(resourceCallback, executor);
                if (VERBOSE_IS_LOGGABLE) {
                    logWithTimeAndKey("Added to existing load", j, engineKey);
                }
                return new LoadStatus(this, resourceCallback, engineJob);
            }
            EngineJob build = this.engineJobFactory.build(engineKey, z3, z4, z5, z6);
            DecodeJob build2 = this.decodeJobFactory.build(glideContext, obj, engineKey, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, build);
            this.jobs.put(engineKey, build);
            build.addCallback(resourceCallback, executor);
            build.start(build2);
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Started new load", j, engineKey);
            }
            return new LoadStatus(this, resourceCallback, build);
        }
        return (LoadStatus) invokeCommon.objValue;
    }

    public LoadStatus load(GlideContext glideContext, Object obj, Key key, int i, int i2, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        InterceptResult invokeCommon;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideContext, obj, key, Integer.valueOf(i), Integer.valueOf(i2), cls, cls2, priority, diskCacheStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), options, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), resourceCallback, executor})) == null) {
            if (VERBOSE_IS_LOGGABLE) {
                j = LogTime.getLogTime();
            } else {
                j = 0;
            }
            long j2 = j;
            EngineKey buildKey = this.keyFactory.buildKey(obj, key, i, i2, map, cls, cls2, options);
            synchronized (this) {
                EngineResource loadFromMemory = loadFromMemory(buildKey, z3, j2);
                if (loadFromMemory == null) {
                    return waitForExistingOrStartNewJob(glideContext, obj, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, buildKey, j2);
                }
                resourceCallback.onResourceReady(loadFromMemory, DataSource.MEMORY_CACHE, false);
                return null;
            }
        }
        return (LoadStatus) invokeCommon.objValue;
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobCancelled(EngineJob engineJob, Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, engineJob, key) == null) {
            synchronized (this) {
                this.jobs.removeIfCurrent(key, engineJob);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void onResourceReleased(Key key, EngineResource engineResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, key, engineResource) == null) {
            this.activeResources.deactivate(key);
            if (engineResource.isMemoryCacheable()) {
                this.cache.put(key, engineResource);
            } else {
                this.resourceRecycler.recycle(engineResource, false);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobComplete(EngineJob engineJob, Key key, EngineResource engineResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, engineJob, key, engineResource) == null) {
            synchronized (this) {
                if (engineResource != null) {
                    if (engineResource.isMemoryCacheable()) {
                        this.activeResources.activate(key, engineResource);
                    }
                }
                this.jobs.removeIfCurrent(key, engineJob);
            }
        }
    }
}
