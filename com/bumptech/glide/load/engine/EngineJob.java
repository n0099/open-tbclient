package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
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
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    public static /* synthetic */ Interceptable $ic;
    public static final EngineResourceFactory DEFAULT_FACTORY;
    public transient /* synthetic */ FieldHolder $fh;
    public final GlideExecutor animationExecutor;
    public final ResourceCallbacksAndExecutors cbs;
    public DataSource dataSource;
    public DecodeJob<R> decodeJob;
    public final GlideExecutor diskCacheExecutor;
    public final EngineJobListener engineJobListener;
    public EngineResource<?> engineResource;
    public final EngineResourceFactory engineResourceFactory;
    public GlideException exception;
    public boolean hasLoadFailed;
    public boolean hasResource;
    public boolean isCacheable;
    public volatile boolean isCancelled;
    public boolean isLoadedFromAlternateCacheKey;
    public Key key;
    public boolean onlyRetrieveFromCache;
    public final AtomicInteger pendingCallbacks;
    public final Pools.Pool<EngineJob<?>> pool;
    public Resource<?> resource;
    public final EngineResource.ResourceListener resourceListener;
    public final GlideExecutor sourceExecutor;
    public final GlideExecutor sourceUnlimitedExecutor;
    public final StateVerifier stateVerifier;
    public boolean useAnimationPool;
    public boolean useUnlimitedSourceGeneratorPool;

    /* loaded from: classes7.dex */
    public class CallLoadFailed implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceCallback cb;
        public final /* synthetic */ EngineJob this$0;

        public CallLoadFailed(EngineJob engineJob, ResourceCallback resourceCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {engineJob, resourceCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = engineJob;
            this.cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.cb.getLock()) {
                    synchronized (this.this$0) {
                        if (this.this$0.cbs.contains(this.cb)) {
                            this.this$0.callCallbackOnLoadFailed(this.cb);
                        }
                        this.this$0.decrementPendingCallbacks();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class CallResourceReady implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceCallback cb;
        public final /* synthetic */ EngineJob this$0;

        public CallResourceReady(EngineJob engineJob, ResourceCallback resourceCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {engineJob, resourceCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = engineJob;
            this.cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.cb.getLock()) {
                    synchronized (this.this$0) {
                        if (this.this$0.cbs.contains(this.cb)) {
                            this.this$0.engineResource.acquire();
                            this.this$0.callCallbackOnResourceReady(this.cb);
                            this.this$0.removeCallback(this.cb);
                        }
                        this.this$0.decrementPendingCallbacks();
                    }
                }
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class EngineResourceFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EngineResourceFactory() {
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

        public <R> EngineResource<R> build(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{resource, Boolean.valueOf(z), key, resourceListener})) == null) {
                return new EngineResource<>(resource, z, true, key, resourceListener);
            }
            return (EngineResource) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ResourceCallbackAndExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResourceCallback cb;
        public final Executor executor;

        public ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resourceCallback, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cb = resourceCallback;
            this.executor = executor;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof ResourceCallbackAndExecutor) {
                    return this.cb.equals(((ResourceCallbackAndExecutor) obj).cb);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.cb.hashCode();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((List) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.callbacksAndExecutors.clear();
            }
        }

        public ResourceCallbacksAndExecutors copy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
            }
            return (ResourceCallbacksAndExecutors) invokeV.objValue;
        }

        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.callbacksAndExecutors.isEmpty();
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.callbacksAndExecutors.iterator();
            }
            return (Iterator) invokeV.objValue;
        }

        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.callbacksAndExecutors.size();
            }
            return invokeV.intValue;
        }

        public ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.callbacksAndExecutors = list;
        }

        public static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, resourceCallback)) == null) {
                return new ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
            }
            return (ResourceCallbackAndExecutor) invokeL.objValue;
        }

        public boolean contains(ResourceCallback resourceCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resourceCallback)) == null) {
                return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
            }
            return invokeL.booleanValue;
        }

        public void remove(ResourceCallback resourceCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, resourceCallback) == null) {
                this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
            }
        }

        public void add(ResourceCallback resourceCallback, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, resourceCallback, executor) == null) {
                this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840970793, "Lcom/bumptech/glide/load/engine/EngineJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840970793, "Lcom/bumptech/glide/load/engine/EngineJob;");
                return;
            }
        }
        DEFAULT_FACTORY = new EngineResourceFactory();
    }

    private GlideExecutor getActiveSourceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.useUnlimitedSourceGeneratorPool) {
                return this.sourceUnlimitedExecutor;
            }
            if (this.useAnimationPool) {
                return this.animationExecutor;
            }
            return this.sourceExecutor;
        }
        return (GlideExecutor) invokeV.objValue;
    }

    private boolean isDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (!this.hasLoadFailed && !this.hasResource && !this.isCancelled) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || isDone()) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.stateVerifier;
        }
        return (StateVerifier) invokeV.objValue;
    }

    public synchronized boolean isCancelled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = this.isCancelled;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean onlyRetrieveFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.onlyRetrieveFromCache;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, DEFAULT_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((GlideExecutor) objArr2[0], (GlideExecutor) objArr2[1], (GlideExecutor) objArr2[2], (GlideExecutor) objArr2[3], (EngineJobListener) objArr2[4], (EngineResource.ResourceListener) objArr2[5], (Pools.Pool) objArr2[6], (EngineResourceFactory) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, engineResourceFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener;
        this.resourceListener = resourceListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }

    private synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            synchronized (this) {
                if (this.key != null) {
                    this.cbs.clear();
                    this.key = null;
                    this.engineResource = null;
                    this.resource = null;
                    this.hasLoadFailed = false;
                    this.isCancelled = false;
                    this.hasResource = false;
                    this.isLoadedFromAlternateCacheKey = false;
                    this.decodeJob.release(false);
                    this.decodeJob = null;
                    this.exception = null;
                    this.dataSource = null;
                    this.pool.release(this);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void decrementPendingCallbacks() {
        boolean z;
        EngineResource<?> engineResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                Preconditions.checkArgument(isDone(), "Not yet complete!");
                int decrementAndGet = this.pendingCallbacks.decrementAndGet();
                if (decrementAndGet >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    engineResource = this.engineResource;
                    release();
                } else {
                    engineResource = null;
                }
            }
            if (engineResource != null) {
                engineResource.release();
            }
        }
    }

    public synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, resourceCallback, executor) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                this.cbs.add(resourceCallback, executor);
                boolean z = true;
                if (this.hasResource) {
                    incrementPendingCallbacks(1);
                    executor.execute(new CallResourceReady(this, resourceCallback));
                } else if (this.hasLoadFailed) {
                    incrementPendingCallbacks(1);
                    executor.execute(new CallLoadFailed(this, resourceCallback));
                } else {
                    if (this.isCancelled) {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
                }
            }
        }
    }

    @GuardedBy("this")
    public void callCallbackOnLoadFailed(ResourceCallback resourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resourceCallback) == null) {
            try {
                resourceCallback.onLoadFailed(this.exception);
            } catch (Throwable th) {
                throw new CallbackException(th);
            }
        }
    }

    @GuardedBy("this")
    public void callCallbackOnResourceReady(ResourceCallback resourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resourceCallback) == null) {
            try {
                resourceCallback.onResourceReady(this.engineResource, this.dataSource, this.isLoadedFromAlternateCacheKey);
            } catch (Throwable th) {
                throw new CallbackException(th);
            }
        }
    }

    public synchronized void incrementPendingCallbacks(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
                Preconditions.checkArgument(isDone(), "Not yet complete!");
                if (this.pendingCallbacks.getAndAdd(i) == 0 && this.engineResource != null) {
                    this.engineResource.acquire();
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, glideException) == null) {
            synchronized (this) {
                this.exception = glideException;
            }
            notifyCallbacksOfException();
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, decodeJob) == null) {
            getActiveSourceExecutor().execute(decodeJob);
        }
    }

    public synchronized void start(DecodeJob<R> decodeJob) {
        GlideExecutor activeSourceExecutor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, decodeJob) == null) {
            synchronized (this) {
                this.decodeJob = decodeJob;
                if (decodeJob.willDecodeFromCache()) {
                    activeSourceExecutor = this.diskCacheExecutor;
                } else {
                    activeSourceExecutor = getActiveSourceExecutor();
                }
                activeSourceExecutor.execute(decodeJob);
            }
        }
    }

    @VisibleForTesting
    public synchronized EngineJob<R> init(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{key, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            synchronized (this) {
                this.key = key;
                this.isCacheable = z;
                this.useUnlimitedSourceGeneratorPool = z2;
                this.useAnimationPool = z3;
                this.onlyRetrieveFromCache = z4;
            }
            return this;
        }
        return (EngineJob) invokeCommon.objValue;
    }

    public void notifyCallbacksOfException() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                if (this.isCancelled) {
                    release();
                } else if (!this.cbs.isEmpty()) {
                    if (!this.hasLoadFailed) {
                        this.hasLoadFailed = true;
                        Key key = this.key;
                        ResourceCallbacksAndExecutors copy = this.cbs.copy();
                        incrementPendingCallbacks(copy.size() + 1);
                        this.engineJobListener.onEngineJobComplete(this, key, null);
                        Iterator<ResourceCallbackAndExecutor> it = copy.iterator();
                        while (it.hasNext()) {
                            ResourceCallbackAndExecutor next = it.next();
                            next.executor.execute(new CallLoadFailed(this, next.cb));
                        }
                        decrementPendingCallbacks();
                        return;
                    }
                    throw new IllegalStateException("Already failed once");
                } else {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
            }
        }
    }

    public void notifyCallbacksOfResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                if (this.isCancelled) {
                    this.resource.recycle();
                    release();
                } else if (!this.cbs.isEmpty()) {
                    if (!this.hasResource) {
                        this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);
                        this.hasResource = true;
                        ResourceCallbacksAndExecutors copy = this.cbs.copy();
                        incrementPendingCallbacks(copy.size() + 1);
                        this.engineJobListener.onEngineJobComplete(this, this.key, this.engineResource);
                        Iterator<ResourceCallbackAndExecutor> it = copy.iterator();
                        while (it.hasNext()) {
                            ResourceCallbackAndExecutor next = it.next();
                            next.executor.execute(new CallResourceReady(this, next.cb));
                        }
                        decrementPendingCallbacks();
                        return;
                    }
                    throw new IllegalStateException("Already have resource");
                } else {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bumptech.glide.load.engine.Resource<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource, DataSource dataSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, resource, dataSource, z) == null) {
            synchronized (this) {
                this.resource = resource;
                this.dataSource = dataSource;
                this.isLoadedFromAlternateCacheKey = z;
            }
            notifyCallbacksOfResult();
        }
    }

    public synchronized void removeCallback(ResourceCallback resourceCallback) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, resourceCallback) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                this.cbs.remove(resourceCallback);
                if (this.cbs.isEmpty()) {
                    cancel();
                    if (!this.hasResource && !this.hasLoadFailed) {
                        z = false;
                        if (z && this.pendingCallbacks.get() == 0) {
                            release();
                        }
                    }
                    z = true;
                    if (z) {
                        release();
                    }
                }
            }
        }
    }
}
