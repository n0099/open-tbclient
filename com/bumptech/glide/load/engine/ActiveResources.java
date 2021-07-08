package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class ActiveResources {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_CLEAN_REF = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public final Map<Key, ResourceWeakReference> activeEngineResources;
    @Nullable
    public volatile DequeuedResourceCallback cb;
    @Nullable
    public Thread cleanReferenceQueueThread;
    public final boolean isActiveResourceRetentionAllowed;
    public volatile boolean isShutdown;
    public EngineResource.ResourceListener listener;
    public final Handler mainHandler;
    @Nullable
    public ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {key, engineResource, referenceQueue, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], (ReferenceQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = (Key) Preconditions.checkNotNull(key);
            this.resource = (engineResource.isCacheable() && z) ? (Resource) Preconditions.checkNotNull(engineResource.getResource()) : null;
            this.isCacheable = engineResource.isCacheable();
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.resource = null;
                clear();
            }
        }
    }

    public ActiveResources(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mainHandler = new Handler(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.bumptech.glide.load.engine.ActiveResources.1
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

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    if (message.what == 1) {
                        this.this$0.cleanupActiveReference((ResourceWeakReference) message.obj);
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        });
        this.activeEngineResources = new HashMap();
        this.isActiveResourceRetentionAllowed = z;
    }

    private ReferenceQueue<EngineResource<?>> getReferenceQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.resourceReferenceQueue == null) {
                this.resourceReferenceQueue = new ReferenceQueue<>();
                Thread thread = new Thread(new Runnable(this) { // from class: com.bumptech.glide.load.engine.ActiveResources.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ActiveResources this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Process.setThreadPriority(10);
                            this.this$0.cleanReferenceQueue();
                        }
                    }
                }, "glide-active-resources");
                this.cleanReferenceQueueThread = thread;
                thread.start();
            }
            return this.resourceReferenceQueue;
        }
        return (ReferenceQueue) invokeV.objValue;
    }

    public void activate(Key key, EngineResource<?> engineResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, key, engineResource) == null) {
            ResourceWeakReference put = this.activeEngineResources.put(key, new ResourceWeakReference(key, engineResource, getReferenceQueue(), this.isActiveResourceRetentionAllowed));
            if (put != null) {
                put.reset();
            }
        }
    }

    public void cleanReferenceQueue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.isShutdown) {
                try {
                    this.mainHandler.obtainMessage(1, (ResourceWeakReference) this.resourceReferenceQueue.remove()).sendToTarget();
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

    public void cleanupActiveReference(@NonNull ResourceWeakReference resourceWeakReference) {
        Resource<?> resource;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resourceWeakReference) == null) {
            Util.assertMainThread();
            this.activeEngineResources.remove(resourceWeakReference.key);
            if (!resourceWeakReference.isCacheable || (resource = resourceWeakReference.resource) == null) {
                return;
            }
            EngineResource<?> engineResource = new EngineResource<>(resource, true, false);
            engineResource.setResourceListener(resourceWeakReference.key, this.listener);
            this.listener.onResourceReleased(resourceWeakReference.key, engineResource);
        }
    }

    public void deactivate(Key key) {
        ResourceWeakReference remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, key) == null) || (remove = this.activeEngineResources.remove(key)) == null) {
            return;
        }
        remove.reset();
    }

    @Nullable
    public EngineResource<?> get(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, key)) == null) {
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
            this.listener = resourceListener;
        }
    }

    @VisibleForTesting
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.isShutdown = true;
            Thread thread = this.cleanReferenceQueueThread;
            if (thread == null) {
                return;
            }
            thread.interrupt();
            try {
                this.cleanReferenceQueueThread.join(TimeUnit.SECONDS.toMillis(5L));
                if (this.cleanReferenceQueueThread.isAlive()) {
                    throw new RuntimeException("Failed to join in time");
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
