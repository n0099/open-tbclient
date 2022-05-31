package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
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
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
/* loaded from: classes4.dex */
public class RequestManager implements LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    public static /* synthetic */ Interceptable $ic;
    public static final RequestOptions DECODE_TYPE_BITMAP;
    public static final RequestOptions DECODE_TYPE_GIF;
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable addSelfToLifecycle;
    public final ConnectivityMonitor connectivityMonitor;
    public final Context context;
    public final Glide glide;
    public final Lifecycle lifecycle;
    public final Handler mainHandler;
    public RequestOptions requestOptions;
    public final RequestTracker requestTracker;
    public final TargetTracker targetTracker;
    public final RequestManagerTreeNode treeNode;

    /* loaded from: classes4.dex */
    public static class ClearTarget extends ViewTarget<View, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, transition) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(@NonNull RequestTracker requestTracker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {requestTracker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requestTracker = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.requestTracker.restartRequests();
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

    private void untrackOrDelegate(@NonNull Target<?> target) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, target) == null) || untrack(target) || this.glide.removeFromManagers(target) || target.getRequest() == null) {
            return;
        }
        Request request = target.getRequest();
        target.setRequest(null);
        request.clear();
    }

    private void updateRequestOptions(@NonNull RequestOptions requestOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, requestOptions) == null) {
            this.requestOptions = this.requestOptions.apply(requestOptions);
        }
    }

    @NonNull
    public RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestOptions)) == null) {
            updateRequestOptions(requestOptions);
            return this;
        }
        return (RequestManager) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? new RequestBuilder<>(this.glide, this, cls, this.context) : (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? as(Bitmap.class).apply(DECODE_TYPE_BITMAP) : (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? as(Drawable.class) : (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? as(File.class).apply(RequestOptions.skipMemoryCacheOf(true)) : (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? as(GifDrawable.class).apply(DECODE_TYPE_GIF) : (RequestBuilder) invokeV.objValue;
    }

    public void clear(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            clear(new ClearTarget(view2));
        }
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? downloadOnly().load(obj) : (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? as(File.class).apply(DOWNLOAD_ONLY_OPTIONS) : (RequestBuilder) invokeV.objValue;
    }

    public RequestOptions getDefaultRequestOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.requestOptions : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cls)) == null) ? this.glide.getGlideContext().getDefaultTransitionOptions(cls) : (TransitionOptions) invokeL.objValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Util.assertMainThread();
            return this.requestTracker.isPaused();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.targetTracker.onDestroy();
            for (Target<?> target : this.targetTracker.getAll()) {
                clear(target);
            }
            this.targetTracker.clear();
            this.requestTracker.clearRequests();
            this.lifecycle.removeListener(this);
            this.lifecycle.removeListener(this.connectivityMonitor);
            this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
            this.glide.unregisterRequestManager(this);
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            resumeRequests();
            this.targetTracker.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            pauseRequests();
            this.targetTracker.onStop();
        }
    }

    public void pauseAllRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            Util.assertMainThread();
            this.requestTracker.pauseAllRequests();
        }
    }

    public void pauseRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Util.assertMainThread();
            this.requestTracker.pauseRequests();
        }
    }

    public void pauseRequestsRecursive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            Util.assertMainThread();
            pauseRequests();
            for (RequestManager requestManager : this.treeNode.getDescendants()) {
                requestManager.pauseRequests();
            }
        }
    }

    public void resumeRequests() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Util.assertMainThread();
            this.requestTracker.resumeRequests();
        }
    }

    public void resumeRequestsRecursive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            Util.assertMainThread();
            resumeRequests();
            for (RequestManager requestManager : this.treeNode.getDescendants()) {
                requestManager.resumeRequests();
            }
        }
    }

    @NonNull
    public RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, requestOptions)) == null) {
            setRequestOptions(requestOptions);
            return this;
        }
        return (RequestManager) invokeL.objValue;
    }

    public void setRequestOptions(@NonNull RequestOptions requestOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, requestOptions) == null) {
            this.requestOptions = requestOptions.m99clone().autoClone();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
        }
        return (String) invokeV.objValue;
    }

    public void track(@NonNull Target<?> target, @NonNull Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, target, request) == null) {
            this.targetTracker.track(target);
            this.requestTracker.runRequest(request);
        }
    }

    public boolean untrack(@NonNull Target<?> target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, target)) == null) {
            Request request = target.getRequest();
            if (request == null) {
                return true;
            }
            if (this.requestTracker.clearRemoveAndRecycle(request)) {
                this.targetTracker.untrack(target);
                target.setRequest(null);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void clear(@Nullable Target<?> target) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, target) == null) || target == null) {
            return;
        }
        if (Util.isOnMainThread()) {
            untrackOrDelegate(target);
        } else {
            this.mainHandler.post(new Runnable(this, target) { // from class: com.bumptech.glide.RequestManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RequestManager this$0;
                public final /* synthetic */ Target val$target;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, target};
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
                    this.val$target = target;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.clear(this.val$target);
                    }
                }
            });
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
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        this.connectivityMonitor = connectivityMonitorFactory.build(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        if (Util.isOnBackgroundThread()) {
            this.mainHandler.post(this.addSelfToLifecycle);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(this.connectivityMonitor);
        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
        glide.registerRequestManager(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bitmap)) == null) ? asDrawable().load(bitmap) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, drawable)) == null) ? asDrawable().load(drawable) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? asDrawable().load(str) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, uri)) == null) ? asDrawable().load(uri) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, file)) == null) ? asDrawable().load(file) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable @DrawableRes @RawRes Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, num)) == null) ? asDrawable().load(num) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public RequestBuilder<Drawable> load(@Nullable URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, url)) == null) ? asDrawable().load(url) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bArr)) == null) ? asDrawable().load(bArr) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) ? asDrawable().load(obj) : (RequestBuilder) invokeL.objValue;
    }
}
