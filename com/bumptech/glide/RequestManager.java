package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    public static /* synthetic */ Interceptable $ic;
    public static final RequestOptions DECODE_TYPE_BITMAP;
    public static final RequestOptions DECODE_TYPE_GIF;
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable addSelfToLifecycle;
    public final ConnectivityMonitor connectivityMonitor;
    public final Context context;
    public final CopyOnWriteArrayList<RequestListener<Object>> defaultRequestListeners;
    public final Glide glide;
    public final Lifecycle lifecycle;
    public boolean pauseAllRequestsOnTrimMemoryModerate;
    @GuardedBy("this")
    public RequestOptions requestOptions;
    @GuardedBy("this")
    public final RequestTracker requestTracker;
    @GuardedBy("this")
    public final TargetTracker targetTracker;
    @GuardedBy("this")
    public final RequestManagerTreeNode treeNode;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, configuration) == null) {
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class ClearTarget extends CustomViewTarget<View, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            }
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, transition) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearTarget(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("RequestManager.this")
        public final RequestTracker requestTracker;
        public final /* synthetic */ RequestManager this$0;

        public RequestManagerConnectivityListener(@NonNull RequestManager requestManager, RequestTracker requestTracker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {requestManager, requestTracker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = requestManager;
            this.requestTracker = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                synchronized (this.this$0) {
                    this.requestTracker.restartRequests();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(689411562, "Lcom/bumptech/glide/RequestManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(689411562, "Lcom/bumptech/glide/RequestManager;");
                return;
            }
        }
        DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
        DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
        DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                this.targetTracker.onDestroy();
                for (Target<?> target : this.targetTracker.getAll()) {
                    clear(target);
                }
                this.targetTracker.clear();
                this.requestTracker.clearRequests();
                this.lifecycle.removeListener(this);
                this.lifecycle.removeListener(this.connectivityMonitor);
                Util.removeCallbacksOnUiThread(this.addSelfToLifecycle);
                this.glide.unregisterRequestManager(this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glide, lifecycle, requestManagerTreeNode, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Glide) objArr2[0], (Lifecycle) objArr2[1], (RequestManagerTreeNode) objArr2[2], (RequestTracker) objArr2[3], (ConnectivityMonitorFactory) objArr2[4], (Context) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glide, lifecycle, requestManagerTreeNode, requestTracker, connectivityMonitorFactory, context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.targetTracker = new TargetTracker();
        this.addSelfToLifecycle = new Runnable(this) { // from class: com.bumptech.glide.RequestManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RequestManager this$0;

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
                    RequestManager requestManager = this.this$0;
                    requestManager.lifecycle.addListener(requestManager);
                }
            }
        };
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        this.connectivityMonitor = connectivityMonitorFactory.build(context.getApplicationContext(), new RequestManagerConnectivityListener(this, requestTracker));
        if (Util.isOnBackgroundThread()) {
            Util.postOnUiThread(this.addSelfToLifecycle);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(this.connectivityMonitor);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(glide.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
        glide.registerRequestManager(this);
    }

    private void untrackOrDelegate(@NonNull Target<?> target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, target) == null) {
            boolean untrack = untrack(target);
            Request request = target.getRequest();
            if (!untrack && !this.glide.removeFromManagers(target) && request != null) {
                target.setRequest(null);
                request.clear();
            }
        }
    }

    private synchronized void updateRequestOptions(@NonNull RequestOptions requestOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, requestOptions) == null) {
            synchronized (this) {
                this.requestOptions = this.requestOptions.apply(requestOptions);
            }
        }
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestListener)) == null) {
            this.defaultRequestListeners.add(requestListener);
            return this;
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestOptions)) == null) {
            synchronized (this) {
                updateRequestOptions(requestOptions);
            }
            return this;
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            return new RequestBuilder<>(this.glide, this, cls, this.context);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public void clear(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            clear(new ClearTarget(view2));
        }
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            return downloadOnly().load(obj);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cls)) == null) {
            return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
        }
        return (TransitionOptions) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bitmap)) == null) {
            return asDrawable().load(bitmap);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i) == null) && i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, requestOptions)) == null) {
            synchronized (this) {
                setRequestOptions(requestOptions);
            }
            return this;
        }
        return (RequestManager) invokeL.objValue;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.pauseAllRequestsOnTrimMemoryModerate = z;
        }
    }

    public synchronized void setRequestOptions(@NonNull RequestOptions requestOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, requestOptions) == null) {
            synchronized (this) {
                this.requestOptions = requestOptions.mo79clone().autoClone();
            }
        }
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return as(Bitmap.class).apply((BaseRequestOptions<?>) DECODE_TYPE_BITMAP);
        }
        return (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return as(Drawable.class);
        }
        return (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
        }
        return (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return as(GifDrawable.class).apply((BaseRequestOptions<?>) DECODE_TYPE_GIF);
        }
        return (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return as(File.class).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
        }
        return (RequestBuilder) invokeV.objValue;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.defaultRequestListeners;
        }
        return (List) invokeV.objValue;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        InterceptResult invokeV;
        RequestOptions requestOptions;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                requestOptions = this.requestOptions;
            }
            return requestOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public synchronized boolean isPaused() {
        InterceptResult invokeV;
        boolean isPaused;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                isPaused = this.requestTracker.isPaused();
            }
            return isPaused;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this) {
                resumeRequests();
                this.targetTracker.onStart();
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            synchronized (this) {
                pauseRequests();
                this.targetTracker.onStop();
            }
        }
    }

    public synchronized void pauseAllRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            synchronized (this) {
                this.requestTracker.pauseAllRequests();
            }
        }
    }

    public synchronized void pauseAllRequestsRecursive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            synchronized (this) {
                pauseAllRequests();
                for (RequestManager requestManager : this.treeNode.getDescendants()) {
                    requestManager.pauseAllRequests();
                }
            }
        }
    }

    public synchronized void pauseRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            synchronized (this) {
                this.requestTracker.pauseRequests();
            }
        }
    }

    public synchronized void pauseRequestsRecursive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            synchronized (this) {
                pauseRequests();
                for (RequestManager requestManager : this.treeNode.getDescendants()) {
                    requestManager.pauseRequests();
                }
            }
        }
    }

    public synchronized void resumeRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            synchronized (this) {
                this.requestTracker.resumeRequests();
            }
        }
    }

    public void clear(@Nullable Target<?> target) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, target) != null) || target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
            return asDrawable().load(drawable);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, uri)) == null) {
            return asDrawable().load(uri);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, file)) == null) {
            return asDrawable().load(file);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable @DrawableRes @RawRes Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, num)) == null) {
            return asDrawable().load(num);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
            return asDrawable().load(obj);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            return asDrawable().load(str);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public RequestBuilder<Drawable> load(@Nullable URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, url)) == null) {
            return asDrawable().load(url);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, bArr)) == null) {
            return asDrawable().load(bArr);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public synchronized void resumeRequestsRecursive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            synchronized (this) {
                Util.assertMainThread();
                resumeRequests();
                for (RequestManager requestManager : this.treeNode.getDescendants()) {
                    requestManager.resumeRequests();
                }
            }
        }
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            synchronized (this) {
                str = super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void track(@NonNull Target<?> target, @NonNull Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, target, request) == null) {
            synchronized (this) {
                this.targetTracker.track(target);
                this.requestTracker.runRequest(request);
            }
        }
    }

    public synchronized boolean untrack(@NonNull Target<?> target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, target)) == null) {
            synchronized (this) {
                Request request = target.getRequest();
                if (request == null) {
                    return true;
                }
                if (this.requestTracker.clearAndRemove(request)) {
                    this.targetTracker.untrack(target);
                    target.setRequest(null);
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
