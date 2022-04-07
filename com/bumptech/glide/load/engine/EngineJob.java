package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final EngineResourceFactory DEFAULT_FACTORY;
    public static final Handler MAIN_THREAD_HANDLER;
    public static final int MSG_CANCELLED = 3;
    public static final int MSG_COMPLETE = 1;
    public static final int MSG_EXCEPTION = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final GlideExecutor animationExecutor;
    public final List<ResourceCallback> cbs;
    public DataSource dataSource;
    public DecodeJob<R> decodeJob;
    public final GlideExecutor diskCacheExecutor;
    public EngineResource<?> engineResource;
    public final EngineResourceFactory engineResourceFactory;
    public GlideException exception;
    public boolean hasLoadFailed;
    public boolean hasResource;
    public List<ResourceCallback> ignoredCallbacks;
    public boolean isCacheable;
    public volatile boolean isCancelled;
    public Key key;
    public final EngineJobListener listener;
    public boolean onlyRetrieveFromCache;
    public final Pools.Pool<EngineJob<?>> pool;
    public Resource<?> resource;
    public final GlideExecutor sourceExecutor;
    public final GlideExecutor sourceUnlimitedExecutor;
    public final StateVerifier stateVerifier;
    public boolean useAnimationPool;
    public boolean useUnlimitedSourceGeneratorPool;

    @VisibleForTesting
    /* loaded from: classes4.dex */
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

        public <R> EngineResource<R> build(Resource<R> resource, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, resource, z)) == null) ? new EngineResource<>(resource, z, true) : (EngineResource) invokeLZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class MainThreadCallback implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MainThreadCallback() {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                EngineJob engineJob = (EngineJob) message.obj;
                int i = message.what;
                if (i == 1) {
                    engineJob.handleResultOnMainThread();
                } else if (i == 2) {
                    engineJob.handleExceptionOnMainThread();
                } else if (i == 3) {
                    engineJob.handleCancelledOnMainThread();
                } else {
                    throw new IllegalStateException("Unrecognized message: " + message.what);
                }
                return true;
            }
            return invokeL.booleanValue;
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
        MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, DEFAULT_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((GlideExecutor) objArr2[0], (GlideExecutor) objArr2[1], (GlideExecutor) objArr2[2], (GlideExecutor) objArr2[3], (EngineJobListener) objArr2[4], (Pools.Pool) objArr2[5], (EngineResourceFactory) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, resourceCallback) == null) {
            if (this.ignoredCallbacks == null) {
                this.ignoredCallbacks = new ArrayList(2);
            }
            if (this.ignoredCallbacks.contains(resourceCallback)) {
                return;
            }
            this.ignoredCallbacks.add(resourceCallback);
        }
    }

    private GlideExecutor getActiveSourceExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.useUnlimitedSourceGeneratorPool) {
                return this.sourceUnlimitedExecutor;
            }
            return this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
        }
        return (GlideExecutor) invokeV.objValue;
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, resourceCallback)) == null) {
            List<ResourceCallback> list = this.ignoredCallbacks;
            return list != null && list.contains(resourceCallback);
        }
        return invokeL.booleanValue;
    }

    private void release(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            Util.assertMainThread();
            this.cbs.clear();
            this.key = null;
            this.engineResource = null;
            this.resource = null;
            List<ResourceCallback> list = this.ignoredCallbacks;
            if (list != null) {
                list.clear();
            }
            this.hasLoadFailed = false;
            this.isCancelled = false;
            this.hasResource = false;
            this.decodeJob.release(z);
            this.decodeJob = null;
            this.exception = null;
            this.dataSource = null;
            this.pool.release(this);
        }
    }

    public void addCallback(ResourceCallback resourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, resourceCallback) == null) {
            Util.assertMainThread();
            this.stateVerifier.throwIfRecycled();
            if (this.hasResource) {
                resourceCallback.onResourceReady(this.engineResource, this.dataSource);
            } else if (this.hasLoadFailed) {
                resourceCallback.onLoadFailed(this.exception);
            } else {
                this.cbs.add(resourceCallback);
            }
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.hasLoadFailed || this.hasResource || this.isCancelled) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.listener.onEngineJobCancelled(this, this.key);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.stateVerifier : (StateVerifier) invokeV.objValue;
    }

    public void handleCancelledOnMainThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                this.listener.onEngineJobCancelled(this, this.key);
                release(false);
                return;
            }
            throw new IllegalStateException("Not cancelled");
        }
    }

    public void handleExceptionOnMainThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                release(false);
            } else if (!this.cbs.isEmpty()) {
                if (!this.hasLoadFailed) {
                    this.hasLoadFailed = true;
                    this.listener.onEngineJobComplete(this, this.key, null);
                    for (ResourceCallback resourceCallback : this.cbs) {
                        if (!isInIgnoredCallbacks(resourceCallback)) {
                            resourceCallback.onLoadFailed(this.exception);
                        }
                    }
                    release(false);
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    public void handleResultOnMainThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                this.resource.recycle();
                release(false);
            } else if (!this.cbs.isEmpty()) {
                if (!this.hasResource) {
                    EngineResource<?> build = this.engineResourceFactory.build(this.resource, this.isCacheable);
                    this.engineResource = build;
                    this.hasResource = true;
                    build.acquire();
                    this.listener.onEngineJobComplete(this, this.key, this.engineResource);
                    int size = this.cbs.size();
                    for (int i = 0; i < size; i++) {
                        ResourceCallback resourceCallback = this.cbs.get(i);
                        if (!isInIgnoredCallbacks(resourceCallback)) {
                            this.engineResource.acquire();
                            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
                        }
                    }
                    this.engineResource.release();
                    release(false);
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    @VisibleForTesting
    public EngineJob<R> init(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{key, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            this.key = key;
            this.isCacheable = z;
            this.useUnlimitedSourceGeneratorPool = z2;
            this.useAnimationPool = z3;
            this.onlyRetrieveFromCache = z4;
            return this;
        }
        return (EngineJob) invokeCommon.objValue;
    }

    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isCancelled : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, glideException) == null) {
            this.exception = glideException;
            MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bumptech.glide.load.engine.Resource<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, resource, dataSource) == null) {
            this.resource = resource;
            this.dataSource = dataSource;
            MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
        }
    }

    public boolean onlyRetrieveFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.onlyRetrieveFromCache : invokeV.booleanValue;
    }

    public void removeCallback(ResourceCallback resourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, resourceCallback) == null) {
            Util.assertMainThread();
            this.stateVerifier.throwIfRecycled();
            if (!this.hasResource && !this.hasLoadFailed) {
                this.cbs.remove(resourceCallback);
                if (this.cbs.isEmpty()) {
                    cancel();
                    return;
                }
                return;
            }
            addIgnoredCallback(resourceCallback);
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, decodeJob) == null) {
            getActiveSourceExecutor().execute(decodeJob);
        }
    }

    public void start(DecodeJob<R> decodeJob) {
        GlideExecutor activeSourceExecutor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, decodeJob) == null) {
            this.decodeJob = decodeJob;
            if (decodeJob.willDecodeFromCache()) {
                activeSourceExecutor = this.diskCacheExecutor;
            } else {
                activeSourceExecutor = getActiveSourceExecutor();
            }
            activeSourceExecutor.execute(decodeJob);
        }
    }

    @VisibleForTesting
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, engineResourceFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.cbs = new ArrayList(2);
        this.stateVerifier = StateVerifier.newInstance();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.listener = engineJobListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }
}
