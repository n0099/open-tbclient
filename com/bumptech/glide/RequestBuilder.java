package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
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
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class RequestBuilder extends BaseRequestOptions implements Cloneable, ModelTypes {
    public static /* synthetic */ Interceptable $ic;
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public RequestBuilder errorBuilder;
    public final Glide glide;
    public final GlideContext glideContext;
    public boolean isDefaultTransitionOptionsSet;
    public boolean isModelSet;
    public boolean isThumbnailBuilt;
    public Object model;
    public List requestListeners;
    public final RequestManager requestManager;
    public Float thumbSizeMultiplier;
    public RequestBuilder thumbnailBuilder;
    public final Class transcodeClass;
    public TransitionOptions transitionOptions;

    /* renamed from: com.bumptech.glide.RequestBuilder$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        public static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1860541297, "Lcom/bumptech/glide/RequestBuilder$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1860541297, "Lcom/bumptech/glide/RequestBuilder$1;");
                    return;
                }
            }
            int[] iArr = new int[Priority.values().length];
            $SwitchMap$com$bumptech$glide$Priority = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-864504900, "Lcom/bumptech/glide/RequestBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-864504900, "Lcom/bumptech/glide/RequestBuilder;");
                return;
            }
        }
        DOWNLOAD_ONLY_OPTIONS = (RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA)).priority(Priority.LOW)).skipMemoryCache(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestBuilder clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequestBuilder requestBuilder = (RequestBuilder) super.m75clone();
            requestBuilder.transitionOptions = requestBuilder.transitionOptions.m74clone();
            if (requestBuilder.requestListeners != null) {
                requestBuilder.requestListeners = new ArrayList(requestBuilder.requestListeners);
            }
            RequestBuilder requestBuilder2 = requestBuilder.thumbnailBuilder;
            if (requestBuilder2 != null) {
                requestBuilder.thumbnailBuilder = requestBuilder2.clone();
            }
            RequestBuilder requestBuilder3 = requestBuilder.errorBuilder;
            if (requestBuilder3 != null) {
                requestBuilder.errorBuilder = requestBuilder3.clone();
            }
            return requestBuilder;
        }
        return (RequestBuilder) invokeV.objValue;
    }

    public RequestBuilder(Glide glide, RequestManager requestManager, Class cls, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glide, requestManager, cls, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isDefaultTransitionOptionsSet = true;
        this.glide = glide;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.glideContext = glide.getGlideContext();
        initRequestListeners(requestManager.getDefaultRequestListeners());
        apply((BaseRequestOptions) requestManager.getDefaultRequestOptions());
    }

    private Target into(Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, this, target, requestListener, baseRequestOptions, executor)) == null) {
            Preconditions.checkNotNull(target);
            if (this.isModelSet) {
                Request buildRequest = buildRequest(target, requestListener, baseRequestOptions, executor);
                Request request = target.getRequest();
                if (buildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(baseRequestOptions, request)) {
                    if (!((Request) Preconditions.checkNotNull(request)).isRunning()) {
                        request.begin();
                    }
                    return target;
                }
                this.requestManager.clear(target);
                target.setRequest(buildRequest);
                this.requestManager.track(target, buildRequest);
                return target;
            }
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        return (Target) invokeLLLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestBuilder(Class cls, RequestBuilder requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, requestBuilder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Glide) objArr2[0], (RequestManager) objArr2[1], (Class) objArr2[2], (Context) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        apply((BaseRequestOptions) requestBuilder);
    }

    private Request buildRequest(Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, this, target, requestListener, baseRequestOptions, executor)) == null) {
            return buildRequestRecursive(new Object(), target, requestListener, null, this.transitionOptions, baseRequestOptions.getPriority(), baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions, executor);
        }
        return (Request) invokeLLLL.objValue;
    }

    private Request buildRequestRecursive(Object obj, Target target, RequestListener requestListener, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i, int i2, BaseRequestOptions baseRequestOptions, Executor executor) {
        InterceptResult invokeCommon;
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{obj, target, requestListener, requestCoordinator, transitionOptions, priority, Integer.valueOf(i), Integer.valueOf(i2), baseRequestOptions, executor})) == null) {
            if (this.errorBuilder != null) {
                ErrorRequestCoordinator errorRequestCoordinator3 = new ErrorRequestCoordinator(obj, requestCoordinator);
                errorRequestCoordinator = errorRequestCoordinator3;
                errorRequestCoordinator2 = errorRequestCoordinator3;
            } else {
                errorRequestCoordinator = null;
                errorRequestCoordinator2 = requestCoordinator;
            }
            Request buildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i, i2, baseRequestOptions, executor);
            if (errorRequestCoordinator == null) {
                return buildThumbnailRequestRecursive;
            }
            int overrideWidth = this.errorBuilder.getOverrideWidth();
            int overrideHeight = this.errorBuilder.getOverrideHeight();
            if (Util.isValidDimensions(i, i2) && !this.errorBuilder.isValidOverride()) {
                overrideWidth = baseRequestOptions.getOverrideWidth();
                overrideHeight = baseRequestOptions.getOverrideHeight();
            }
            RequestBuilder requestBuilder = this.errorBuilder;
            ErrorRequestCoordinator errorRequestCoordinator4 = errorRequestCoordinator;
            errorRequestCoordinator4.setRequests(buildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(obj, target, requestListener, errorRequestCoordinator4, requestBuilder.transitionOptions, requestBuilder.getPriority(), overrideWidth, overrideHeight, this.errorBuilder, executor));
            return errorRequestCoordinator4;
        }
        return (Request) invokeCommon.objValue;
    }

    private Request buildThumbnailRequestRecursive(Object obj, Target target, RequestListener requestListener, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i, int i2, BaseRequestOptions baseRequestOptions, Executor executor) {
        InterceptResult invokeCommon;
        TransitionOptions transitionOptions2;
        Priority thumbnailPriority;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{obj, target, requestListener, requestCoordinator, transitionOptions, priority, Integer.valueOf(i), Integer.valueOf(i2), baseRequestOptions, executor})) == null) {
            RequestBuilder requestBuilder = this.thumbnailBuilder;
            if (requestBuilder != null) {
                if (!this.isThumbnailBuilt) {
                    TransitionOptions transitionOptions3 = requestBuilder.transitionOptions;
                    if (requestBuilder.isDefaultTransitionOptionsSet) {
                        transitionOptions2 = transitionOptions;
                    } else {
                        transitionOptions2 = transitionOptions3;
                    }
                    if (this.thumbnailBuilder.isPrioritySet()) {
                        thumbnailPriority = this.thumbnailBuilder.getPriority();
                    } else {
                        thumbnailPriority = getThumbnailPriority(priority);
                    }
                    Priority priority2 = thumbnailPriority;
                    int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
                    int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
                    if (Util.isValidDimensions(i, i2) && !this.thumbnailBuilder.isValidOverride()) {
                        overrideWidth = baseRequestOptions.getOverrideWidth();
                        overrideHeight = baseRequestOptions.getOverrideHeight();
                    }
                    ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, requestCoordinator);
                    Request obtainRequest = obtainRequest(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor);
                    this.isThumbnailBuilt = true;
                    RequestBuilder requestBuilder2 = this.thumbnailBuilder;
                    Request buildRequestRecursive = requestBuilder2.buildRequestRecursive(obj, target, requestListener, thumbnailRequestCoordinator, transitionOptions2, priority2, overrideWidth, overrideHeight, requestBuilder2, executor);
                    this.isThumbnailBuilt = false;
                    thumbnailRequestCoordinator.setRequests(obtainRequest, buildRequestRecursive);
                    return thumbnailRequestCoordinator;
                }
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            } else if (this.thumbSizeMultiplier != null) {
                ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, requestCoordinator);
                thumbnailRequestCoordinator2.setRequests(obtainRequest(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2, executor), obtainRequest(obj, target, requestListener, baseRequestOptions.m75clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator2, transitionOptions, getThumbnailPriority(priority), i, i2, executor));
                return thumbnailRequestCoordinator2;
            } else {
                return obtainRequest(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i, i2, executor);
            }
        }
        return (Request) invokeCommon.objValue;
    }

    private RequestBuilder cloneWithNullErrorAndThumbnail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return clone().error((RequestBuilder) null).thumbnail((RequestBuilder) null);
        }
        return (RequestBuilder) invokeV.objValue;
    }

    public RequestBuilder getDownloadOnlyRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new RequestBuilder(File.class, this).apply((BaseRequestOptions) DOWNLOAD_ONLY_OPTIONS);
        }
        return (RequestBuilder) invokeV.objValue;
    }

    public Target preload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        return (Target) invokeV.objValue;
    }

    public FutureTarget submit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        return (FutureTarget) invokeV.objValue;
    }

    private Priority getThumbnailPriority(Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, priority)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$Priority[priority.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new IllegalArgumentException("unknown priority: " + getPriority());
                    }
                    return Priority.IMMEDIATE;
                }
                return Priority.HIGH;
            }
            return Priority.NORMAL;
        }
        return (Priority) invokeL.objValue;
    }

    private void initRequestListeners(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                addListener((RequestListener) it.next());
            }
        }
    }

    private RequestBuilder loadGeneric(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, obj)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().loadGeneric(obj);
            }
            this.model = obj;
            this.isModelSet = true;
            return (RequestBuilder) selfOrThrowIfLocked();
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestBuilder apply(BaseRequestOptions baseRequestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseRequestOptions)) == null) {
            Preconditions.checkNotNull(baseRequestOptions);
            return (RequestBuilder) super.apply(baseRequestOptions);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @Deprecated
    public Target downloadOnly(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, target)) == null) {
            return getDownloadOnlyRequest().into(target);
        }
        return (Target) invokeL.objValue;
    }

    public RequestBuilder error(RequestBuilder requestBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, requestBuilder)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().error(requestBuilder);
            }
            this.errorBuilder = requestBuilder;
            return (RequestBuilder) selfOrThrowIfLocked();
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public Target into(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, target)) == null) {
            return into(target, null, Executors.mainThreadExecutor());
        }
        return (Target) invokeL.objValue;
    }

    public RequestBuilder listener(RequestListener requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, requestListener)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().listener(requestListener);
            }
            this.requestListeners = null;
            return addListener(requestListener);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bitmap)) == null) {
            return loadGeneric(bitmap).apply((BaseRequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public RequestBuilder thumbnail(RequestBuilder requestBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, requestBuilder)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().thumbnail(requestBuilder);
            }
            this.thumbnailBuilder = requestBuilder;
            return (RequestBuilder) selfOrThrowIfLocked();
        }
        return (RequestBuilder) invokeL.objValue;
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(BaseRequestOptions baseRequestOptions, Request request) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, baseRequestOptions, request)) == null) {
            if (!baseRequestOptions.isMemoryCacheable() && request.isComplete()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public FutureTarget downloadOnly(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return getDownloadOnlyRequest().submit(i, i2);
        }
        return (FutureTarget) invokeII.objValue;
    }

    @Deprecated
    public FutureTarget into(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            return submit(i, i2);
        }
        return (FutureTarget) invokeII.objValue;
    }

    public Target preload(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048611, this, i, i2)) == null) {
            return into(PreloadTarget.obtain(this.requestManager, i, i2));
        }
        return (Target) invokeII.objValue;
    }

    public FutureTarget submit(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i, i2)) == null) {
            RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
            return (FutureTarget) into(requestFutureTarget, requestFutureTarget, Executors.directExecutor());
        }
        return (FutureTarget) invokeII.objValue;
    }

    private Request obtainRequest(Object obj, Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i, int i2, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, Integer.valueOf(i), Integer.valueOf(i2), executor})) == null) {
            Context context = this.context;
            GlideContext glideContext = this.glideContext;
            return SingleRequest.obtain(context, glideContext, obj, this.model, this.transcodeClass, baseRequestOptions, i, i2, priority, target, requestListener, this.requestListeners, requestCoordinator, glideContext.getEngine(), transitionOptions.getTransitionFactory(), executor);
        }
        return (Request) invokeCommon.objValue;
    }

    public RequestBuilder addListener(RequestListener requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestListener)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().addListener(requestListener);
            }
            if (requestListener != null) {
                if (this.requestListeners == null) {
                    this.requestListeners = new ArrayList();
                }
                this.requestListeners.add(requestListener);
            }
            return (RequestBuilder) selfOrThrowIfLocked();
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bArr)) == null) {
            RequestBuilder loadGeneric = loadGeneric(bArr);
            if (!loadGeneric.isDiskCacheStrategySet()) {
                loadGeneric = loadGeneric.apply((BaseRequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
            }
            if (!loadGeneric.isSkipMemoryCacheSet()) {
                return loadGeneric.apply((BaseRequestOptions) RequestOptions.skipMemoryCacheOf(true));
            }
            return loadGeneric;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public RequestBuilder thumbnail(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048614, this, f)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().thumbnail(f);
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.thumbSizeMultiplier = Float.valueOf(f);
                return (RequestBuilder) selfOrThrowIfLocked();
            }
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        return (RequestBuilder) invokeF.objValue;
    }

    public RequestBuilder transition(TransitionOptions transitionOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, transitionOptions)) == null) {
            if (isAutoCloneEnabled()) {
                return clone().transition(transitionOptions);
            }
            this.transitionOptions = (TransitionOptions) Preconditions.checkNotNull(transitionOptions);
            this.isDefaultTransitionOptionsSet = false;
            return (RequestBuilder) selfOrThrowIfLocked();
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public RequestBuilder error(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj == null) {
                return error((RequestBuilder) null);
            }
            return error(cloneWithNullErrorAndThumbnail().load(obj));
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            return loadGeneric(drawable).apply((BaseRequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public RequestBuilder thumbnail(RequestBuilder... requestBuilderArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, requestBuilderArr)) == null) {
            if (requestBuilderArr != null && requestBuilderArr.length != 0) {
                return thumbnail(Arrays.asList(requestBuilderArr));
            }
            return thumbnail((RequestBuilder) null);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public Target into(Target target, RequestListener requestListener, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, target, requestListener, executor)) == null) {
            return into(target, requestListener, this, executor);
        }
        return (Target) invokeLLL.objValue;
    }

    public ViewTarget into(ImageView imageView) {
        InterceptResult invokeL;
        BaseRequestOptions baseRequestOptions;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imageView)) == null) {
            Util.assertMainThread();
            Preconditions.checkNotNull(imageView);
            if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
                switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                    case 1:
                        baseRequestOptions = clone().optionalCenterCrop();
                        break;
                    case 2:
                        baseRequestOptions = clone().optionalCenterInside();
                        break;
                    case 3:
                    case 4:
                    case 5:
                        baseRequestOptions = clone().optionalFitCenter();
                        break;
                    case 6:
                        baseRequestOptions = clone().optionalCenterInside();
                        break;
                }
                return (ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, baseRequestOptions, Executors.mainThreadExecutor());
            }
            baseRequestOptions = this;
            return (ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, baseRequestOptions, Executors.mainThreadExecutor());
        }
        return (ViewTarget) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            return loadGeneric(uri);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, file)) == null) {
            return loadGeneric(file);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, num)) == null) {
            return loadGeneric(num).apply((BaseRequestOptions) RequestOptions.signatureOf(AndroidResourceSignature.obtain(this.context)));
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            return loadGeneric(obj);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder load(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            return loadGeneric(str);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder load(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, url)) == null) {
            return loadGeneric(url);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    public RequestBuilder thumbnail(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, list)) == null) {
            RequestBuilder requestBuilder = null;
            if (list != null && !list.isEmpty()) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    RequestBuilder requestBuilder2 = (RequestBuilder) list.get(size);
                    if (requestBuilder2 != null) {
                        if (requestBuilder == null) {
                            requestBuilder = requestBuilder2;
                        } else {
                            requestBuilder = requestBuilder2.thumbnail(requestBuilder);
                        }
                    }
                }
                return thumbnail(requestBuilder);
            }
            return thumbnail((RequestBuilder) null);
        }
        return (RequestBuilder) invokeL.objValue;
    }
}
