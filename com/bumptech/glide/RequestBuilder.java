package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
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
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class RequestBuilder<TranscodeType> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    public static /* synthetic */ Interceptable $ic;
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public final RequestOptions defaultRequestOptions;
    @Nullable
    public RequestBuilder<TranscodeType> errorBuilder;
    public final Glide glide;
    public final GlideContext glideContext;
    public boolean isDefaultTransitionOptionsSet;
    public boolean isModelSet;
    public boolean isThumbnailBuilt;
    @Nullable
    public Object model;
    @Nullable
    public List<RequestListener<TranscodeType>> requestListeners;
    public final RequestManager requestManager;
    @NonNull
    public RequestOptions requestOptions;
    @Nullable
    public Float thumbSizeMultiplier;
    @Nullable
    public RequestBuilder<TranscodeType> thumbnailBuilder;
    public final Class<TranscodeType> transcodeClass;
    @NonNull
    public TransitionOptions<?, ? super TranscodeType> transitionOptions;

    /* renamed from: com.bumptech.glide.RequestBuilder$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        public static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1860541266, "Lcom/bumptech/glide/RequestBuilder$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1860541266, "Lcom/bumptech/glide/RequestBuilder$2;");
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
        DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    public RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
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
        this.defaultRequestOptions = requestManager.getDefaultRequestOptions();
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.requestOptions = this.defaultRequestOptions;
        this.glideContext = glide.getGlideContext();
    }

    private Request buildRequest(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, target, requestListener, requestOptions)) == null) ? buildRequestRecursive(target, requestListener, null, this.transitionOptions, requestOptions.getPriority(), requestOptions.getOverrideWidth(), requestOptions.getOverrideHeight(), requestOptions) : (Request) invokeLLL.objValue;
    }

    private Request buildRequestRecursive(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, RequestOptions requestOptions) {
        InterceptResult invokeCommon;
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{target, requestListener, requestCoordinator, transitionOptions, priority, Integer.valueOf(i), Integer.valueOf(i2), requestOptions})) == null) {
            if (this.errorBuilder != null) {
                errorRequestCoordinator2 = new ErrorRequestCoordinator(requestCoordinator);
                errorRequestCoordinator = errorRequestCoordinator2;
            } else {
                errorRequestCoordinator = null;
                errorRequestCoordinator2 = requestCoordinator;
            }
            Request buildThumbnailRequestRecursive = buildThumbnailRequestRecursive(target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i, i2, requestOptions);
            if (errorRequestCoordinator == null) {
                return buildThumbnailRequestRecursive;
            }
            int overrideWidth = this.errorBuilder.requestOptions.getOverrideWidth();
            int overrideHeight = this.errorBuilder.requestOptions.getOverrideHeight();
            if (Util.isValidDimensions(i, i2) && !this.errorBuilder.requestOptions.isValidOverride()) {
                overrideWidth = requestOptions.getOverrideWidth();
                overrideHeight = requestOptions.getOverrideHeight();
            }
            RequestBuilder<TranscodeType> requestBuilder = this.errorBuilder;
            ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
            errorRequestCoordinator3.setRequests(buildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(target, requestListener, errorRequestCoordinator, requestBuilder.transitionOptions, requestBuilder.requestOptions.getPriority(), overrideWidth, overrideHeight, this.errorBuilder.requestOptions));
            return errorRequestCoordinator3;
        }
        return (Request) invokeCommon.objValue;
    }

    private Request buildThumbnailRequestRecursive(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, RequestOptions requestOptions) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{target, requestListener, requestCoordinator, transitionOptions, priority, Integer.valueOf(i), Integer.valueOf(i2), requestOptions})) == null) {
            RequestBuilder<TranscodeType> requestBuilder = this.thumbnailBuilder;
            if (requestBuilder != null) {
                if (!this.isThumbnailBuilt) {
                    TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.isDefaultTransitionOptionsSet ? transitionOptions : requestBuilder.transitionOptions;
                    Priority priority2 = this.thumbnailBuilder.requestOptions.isPrioritySet() ? this.thumbnailBuilder.requestOptions.getPriority() : getThumbnailPriority(priority);
                    int overrideWidth = this.thumbnailBuilder.requestOptions.getOverrideWidth();
                    int overrideHeight = this.thumbnailBuilder.requestOptions.getOverrideHeight();
                    if (Util.isValidDimensions(i, i2) && !this.thumbnailBuilder.requestOptions.isValidOverride()) {
                        overrideWidth = requestOptions.getOverrideWidth();
                        overrideHeight = requestOptions.getOverrideHeight();
                    }
                    ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
                    Request obtainRequest = obtainRequest(target, requestListener, requestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2);
                    this.isThumbnailBuilt = true;
                    RequestBuilder<TranscodeType> requestBuilder2 = this.thumbnailBuilder;
                    Request buildRequestRecursive = requestBuilder2.buildRequestRecursive(target, requestListener, thumbnailRequestCoordinator, transitionOptions2, priority2, overrideWidth, overrideHeight, requestBuilder2.requestOptions);
                    this.isThumbnailBuilt = false;
                    thumbnailRequestCoordinator.setRequests(obtainRequest, buildRequestRecursive);
                    return thumbnailRequestCoordinator;
                }
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            } else if (this.thumbSizeMultiplier != null) {
                ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(requestCoordinator);
                thumbnailRequestCoordinator2.setRequests(obtainRequest(target, requestListener, requestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2), obtainRequest(target, requestListener, requestOptions.m75clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator2, transitionOptions, getThumbnailPriority(priority), i, i2));
                return thumbnailRequestCoordinator2;
            } else {
                return obtainRequest(target, requestListener, requestOptions, requestCoordinator, transitionOptions, priority, i, i2);
            }
        }
        return (Request) invokeCommon.objValue;
    }

    @NonNull
    private Priority getThumbnailPriority(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, priority)) == null) {
            int i = AnonymousClass2.$SwitchMap$com$bumptech$glide$Priority[priority.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new IllegalArgumentException("unknown priority: " + this.requestOptions.getPriority());
                    }
                    return Priority.IMMEDIATE;
                }
                return Priority.HIGH;
            }
            return Priority.NORMAL;
        }
        return (Priority) invokeL.objValue;
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(RequestOptions requestOptions, Request request) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, requestOptions, request)) == null) ? !requestOptions.isMemoryCacheable() && request.isComplete() : invokeLL.booleanValue;
    }

    @NonNull
    private RequestBuilder<TranscodeType> loadGeneric(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, obj)) == null) {
            this.model = obj;
            this.isModelSet = true;
            return this;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    private Request obtainRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{target, requestListener, requestOptions, requestCoordinator, transitionOptions, priority, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            Context context = this.context;
            GlideContext glideContext = this.glideContext;
            return SingleRequest.obtain(context, glideContext, this.model, this.transcodeClass, requestOptions, i, i2, priority, target, requestListener, this.requestListeners, requestCoordinator, glideContext.getEngine(), transitionOptions.getTransitionFactory());
        }
        return (Request) invokeCommon.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestListener)) == null) {
            if (requestListener != null) {
                if (this.requestListeners == null) {
                    this.requestListeners = new ArrayList();
                }
                this.requestListeners.add(requestListener);
            }
            return this;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> apply(@NonNull RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestOptions)) == null) {
            Preconditions.checkNotNull(requestOptions);
            this.requestOptions = getMutableOptions().apply(requestOptions);
            return this;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @CheckResult
    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(@NonNull Y y) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y)) == null) ? (Y) getDownloadOnlyRequest().into((RequestBuilder<File>) y) : (Y) invokeL.objValue;
    }

    @NonNull
    public RequestBuilder<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, requestBuilder)) == null) {
            this.errorBuilder = requestBuilder;
            return this;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> getDownloadOnlyRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new RequestBuilder(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS) : (RequestBuilder) invokeV.objValue;
    }

    @NonNull
    public RequestOptions getMutableOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequestOptions requestOptions = this.defaultRequestOptions;
            RequestOptions requestOptions2 = this.requestOptions;
            return requestOptions == requestOptions2 ? requestOptions2.m75clone() : requestOptions2;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y y) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, y)) == null) ? (Y) into((RequestBuilder<TranscodeType>) y, (RequestListener) null) : (Y) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, requestListener)) == null) {
            this.requestListeners = null;
            return addListener(requestListener);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    public Target<TranscodeType> preload(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048609, this, i, i2)) == null) ? into((RequestBuilder<TranscodeType>) PreloadTarget.obtain(this.requestManager, i, i2)) : (Target) invokeII.objValue;
    }

    @NonNull
    public FutureTarget<TranscodeType> submit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? submit(Integer.MIN_VALUE, Integer.MIN_VALUE) : (FutureTarget) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, requestBuilder)) == null) {
            this.thumbnailBuilder = requestBuilder;
            return this;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, transitionOptions)) == null) {
            this.transitionOptions = (TransitionOptions) Preconditions.checkNotNull(transitionOptions);
            this.isDefaultTransitionOptionsSet = false;
            return this;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @CheckResult
    /* renamed from: clone */
    public RequestBuilder<TranscodeType> m73clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
                requestBuilder.requestOptions = requestBuilder.requestOptions.m75clone();
                requestBuilder.transitionOptions = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.transitionOptions.m74clone();
                return requestBuilder;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return (RequestBuilder) invokeV.objValue;
    }

    @CheckResult
    @Deprecated
    public FutureTarget<File> downloadOnly(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) ? getDownloadOnlyRequest().submit(i, i2) : (FutureTarget) invokeII.objValue;
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, y, requestListener)) == null) ? (Y) into(y, requestListener, getMutableOptions()) : (Y) invokeLL.objValue;
    }

    @NonNull
    public FutureTarget<TranscodeType> submit(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048611, this, i, i2)) == null) {
            RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.glideContext.getMainHandler(), i, i2);
            if (Util.isOnBackgroundThread()) {
                this.glideContext.getMainHandler().post(new Runnable(this, requestFutureTarget) { // from class: com.bumptech.glide.RequestBuilder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestBuilder this$0;
                    public final /* synthetic */ RequestFutureTarget val$target;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, requestFutureTarget};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$target = requestFutureTarget;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.val$target.isCancelled()) {
                            return;
                        }
                        RequestBuilder requestBuilder = this.this$0;
                        RequestFutureTarget requestFutureTarget2 = this.val$target;
                        requestBuilder.into((RequestBuilder) requestFutureTarget2, (RequestListener) requestFutureTarget2);
                    }
                });
            } else {
                into((RequestBuilder<TranscodeType>) requestFutureTarget, requestFutureTarget);
            }
            return requestFutureTarget;
        }
        return (FutureTarget) invokeII.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, requestBuilderArr)) == null) {
            RequestBuilder<TranscodeType> requestBuilder = null;
            if (requestBuilderArr != null && requestBuilderArr.length != 0) {
                for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
                    RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArr[length];
                    if (requestBuilder2 != null) {
                        requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
                    }
                }
                return thumbnail(requestBuilder);
            }
            return thumbnail((RequestBuilder) null);
        }
        return (RequestBuilder) invokeL.objValue;
    }

    private <Y extends Target<TranscodeType>> Y into(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, @NonNull RequestOptions requestOptions) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, y, requestListener, requestOptions)) == null) {
            Util.assertMainThread();
            Preconditions.checkNotNull(y);
            if (this.isModelSet) {
                RequestOptions autoClone = requestOptions.autoClone();
                Request buildRequest = buildRequest(y, requestListener, autoClone);
                Request request = y.getRequest();
                if (buildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(autoClone, request)) {
                    buildRequest.recycle();
                    if (!((Request) Preconditions.checkNotNull(request)).isRunning()) {
                        request.begin();
                    }
                    return y;
                }
                this.requestManager.clear((Target<?>) y);
                y.setRequest(buildRequest);
                this.requestManager.track(y, buildRequest);
                return y;
            }
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        return (Y) invokeLLL.objValue;
    }

    @NonNull
    public Target<TranscodeType> preload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? preload(Integer.MIN_VALUE, Integer.MIN_VALUE) : (Target) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048612, this, f)) == null) {
            if (f >= 0.0f && f <= 1.0f) {
                this.thumbSizeMultiplier = Float.valueOf(f);
                return this;
            }
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        return (RequestBuilder) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) ? loadGeneric(obj) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
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
        this.requestOptions = requestBuilder.requestOptions;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bitmap)) == null) ? loadGeneric(bitmap).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, drawable)) == null) ? loadGeneric(drawable).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? loadGeneric(str) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, uri)) == null) ? loadGeneric(uri) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, file)) == null) ? loadGeneric(file) : (RequestBuilder) invokeL.objValue;
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> into(@NonNull ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, imageView)) == null) {
            Util.assertMainThread();
            Preconditions.checkNotNull(imageView);
            RequestOptions requestOptions = this.requestOptions;
            if (!requestOptions.isTransformationSet() && requestOptions.isTransformationAllowed() && imageView.getScaleType() != null) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                    case 1:
                        requestOptions = requestOptions.m75clone().optionalCenterCrop();
                        break;
                    case 2:
                        requestOptions = requestOptions.m75clone().optionalCenterInside();
                        break;
                    case 3:
                    case 4:
                    case 5:
                        requestOptions = requestOptions.m75clone().optionalFitCenter();
                        break;
                    case 6:
                        requestOptions = requestOptions.m75clone().optionalCenterInside();
                        break;
                }
            }
            return (ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestOptions);
        }
        return (ViewTarget) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable @DrawableRes @RawRes Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, num)) == null) ? loadGeneric(num).apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(this.context))) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public RequestBuilder<TranscodeType> load(@Nullable URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, url)) == null) ? loadGeneric(url) : (RequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> load(@Nullable byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bArr)) == null) {
            RequestBuilder<TranscodeType> loadGeneric = loadGeneric(bArr);
            if (!loadGeneric.requestOptions.isDiskCacheStrategySet()) {
                loadGeneric = loadGeneric.apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
            }
            return !loadGeneric.requestOptions.isSkipMemoryCacheSet() ? loadGeneric.apply(RequestOptions.skipMemoryCacheOf(true)) : loadGeneric;
        }
        return (RequestBuilder) invokeL.objValue;
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) ? submit(i, i2) : (FutureTarget) invokeII.objValue;
    }
}
