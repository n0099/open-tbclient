package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class ActiveResources {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public final Map<Key, ResourceWeakReference> activeEngineResources;
    @Nullable
    public volatile DequeuedResourceCallback cb;
    public final boolean isActiveResourceRetentionAllowed;
    public volatile boolean isShutdown;
    public EngineResource.ResourceListener listener;
    public final Executor monitorClearedResourcesExecutor;
    public final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean isCacheable;
        public final Key key;
        @Nullable
        public Resource<?> resource;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceWeakReference(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            Resource<?> resource;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {key, engineResource, referenceQueue, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], (ReferenceQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = (Key) Preconditions.checkNotNull(key);
            if (engineResource.isMemoryCacheable() && z) {
                resource = (Resource) Preconditions.checkNotNull(engineResource.getResource());
            } else {
                resource = null;
            }
            this.resource = resource;
            this.isCacheable = engineResource.isMemoryCacheable();
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.resource = null;
                clear();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bumptech.glide.load.engine.ActiveResources.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
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

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(new Runnable(this, runnable) { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ Runnable val$r;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$r = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Process.setThreadPriority(10);
                                this.val$r.run();
                            }
                        }
                    }, "glide-active-resources");
                }
                return (Thread) invokeL.objValue;
            }
        }));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Executor) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public ActiveResources(boolean z, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue<>();
        this.isActiveResourceRetentionAllowed = z;
        this.monitorClearedResourcesExecutor = executor;
        executor.execute(new Runnable(this) { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActiveResources this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.cleanReferenceQueue();
                }
            }
        });
    }

    public synchronized void activate(Key key, EngineResource<?> engineResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, key, engineResource) == null) {
            synchronized (this) {
                ResourceWeakReference put = this.activeEngineResources.put(key, new ResourceWeakReference(key, engineResource, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed));
                if (put != null) {
                    put.reset();
                }
            }
        }
    }

    public void cleanReferenceQueue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.isShutdown) {
                try {
                    cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());
                    DequeuedResourceCallback dequeuedResourceCallback = this.cb;
                    if (dequeuedResourceCallback != null) {
                        dequeuedResourceCallback.onResourceDequeued();
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @VisibleForTesting
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.isShutdown = true;
            Executor executor = this.monitorClearedResourcesExecutor;
            if (executor instanceof ExecutorService) {
                com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) executor);
            }
        }
    }

    public void cleanupActiveReference(@NonNull ResourceWeakReference resourceWeakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resourceWeakReference) == null) {
            synchronized (this) {
                this.activeEngineResources.remove(resourceWeakReference.key);
                if (resourceWeakReference.isCacheable && resourceWeakReference.resource != null) {
                    this.listener.onResourceReleased(resourceWeakReference.key, new EngineResource<>(resourceWeakReference.resource, true, false, resourceWeakReference.key, this.listener));
                }
            }
        }
    }

    public synchronized void deactivate(Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, key) == null) {
            synchronized (this) {
                ResourceWeakReference remove = this.activeEngineResources.remove(key);
                if (remove != null) {
                    remove.reset();
                }
            }
        }
    }

    @Nullable
    public synchronized EngineResource<?> get(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, key)) == null) {
            synchronized (this) {
                ResourceWeakReference resourceWeakReference = this.activeEngineResources.get(key);
                if (resourceWeakReference == null) {
                    return null;
                }
                EngineResource<?> engineResource = resourceWeakReference.get();
                if (engineResource == null) {
                    cleanupActiveReference(resourceWeakReference);
                }
                return engineResource;
            }
        }
        return (EngineResource) invokeL.objValue;
    }

    @VisibleForTesting
    public void setDequeuedResourceCallback(DequeuedResourceCallback dequeuedResourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dequeuedResourceCallback) == null) {
            this.cb = dequeuedResourceCallback;
        }
    }

    public void setListener(EngineResource.ResourceListener resourceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resourceListener) == null) {
            synchronized (resourceListener) {
                synchronized (this) {
                    this.listener = resourceListener;
                }
            }
        }
    }
}
