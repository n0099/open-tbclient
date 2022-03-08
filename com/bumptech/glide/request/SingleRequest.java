package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
/* loaded from: classes7.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GLIDE_TAG = "Glide";
    public static final boolean IS_VERBOSE_LOGGABLE;
    public static final Pools.Pool<SingleRequest<?>> POOL;
    public static final String TAG = "Request";
    public transient /* synthetic */ FieldHolder $fh;
    public TransitionFactory<? super R> animationFactory;
    public Context context;
    public Engine engine;
    public Drawable errorDrawable;
    public Drawable fallbackDrawable;
    public GlideContext glideContext;
    public int height;
    public boolean isCallingCallbacks;
    public Engine.LoadStatus loadStatus;
    @Nullable
    public Object model;
    public int overrideHeight;
    public int overrideWidth;
    public Drawable placeholderDrawable;
    public Priority priority;
    public RequestCoordinator requestCoordinator;
    @Nullable
    public List<RequestListener<R>> requestListeners;
    public RequestOptions requestOptions;
    public Resource<R> resource;
    public long startTime;
    public final StateVerifier stateVerifier;
    public Status status;
    @Nullable
    public final String tag;
    public Target<R> target;
    @Nullable
    public RequestListener<R> targetListener;
    public Class<R> transcodeClass;
    public int width;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status CLEARED;
        public static final Status COMPLETE;
        public static final Status FAILED;
        public static final Status PENDING;
        public static final Status RUNNING;
        public static final Status WAITING_FOR_SIZE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1630736825, "Lcom/bumptech/glide/request/SingleRequest$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1630736825, "Lcom/bumptech/glide/request/SingleRequest$Status;");
                    return;
                }
            }
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status(TornadoLiteRuntime.STATE_RUNNING, 1);
            WAITING_FOR_SIZE = new Status("WAITING_FOR_SIZE", 2);
            COMPLETE = new Status("COMPLETE", 3);
            FAILED = new Status("FAILED", 4);
            Status status = new Status("CLEARED", 5);
            CLEARED = status;
            $VALUES = new Status[]{PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, status};
        }

        public Status(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1906520377, "Lcom/bumptech/glide/request/SingleRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1906520377, "Lcom/bumptech/glide/request/SingleRequest;");
                return;
            }
        }
        POOL = FactoryPools.simple(150, new FactoryPools.Factory<SingleRequest<?>>() { // from class: com.bumptech.glide.request.SingleRequest.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public SingleRequest<?> create() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new SingleRequest<>() : (SingleRequest) invokeV.objValue;
            }
        });
        IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    public SingleRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void assertNotCallingCallbacks() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean canNotifyCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
        }
        return invokeV.booleanValue;
    }

    private boolean canNotifyStatusChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
        }
        return invokeV.booleanValue;
    }

    private boolean canSetResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            return requestCoordinator == null || requestCoordinator.canSetImage(this);
        }
        return invokeV.booleanValue;
    }

    private void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.target.removeCallback(this);
            Engine.LoadStatus loadStatus = this.loadStatus;
            if (loadStatus != null) {
                loadStatus.cancel();
                this.loadStatus = null;
            }
        }
    }

    private Drawable getErrorDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.errorDrawable == null) {
                Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
                this.errorDrawable = errorPlaceholder;
                if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                    this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
                }
            }
            return this.errorDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable getFallbackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.fallbackDrawable == null) {
                Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
                this.fallbackDrawable = fallbackDrawable;
                if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                    this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
                }
            }
            return this.fallbackDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable getPlaceholderDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.placeholderDrawable == null) {
                Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
                this.placeholderDrawable = placeholderDrawable;
                if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                    this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
                }
            }
            return this.placeholderDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private void init(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{context, glideContext, obj, cls, requestOptions, Integer.valueOf(i2), Integer.valueOf(i3), priority, target, requestListener, list, requestCoordinator, engine, transitionFactory}) == null) {
            this.context = context;
            this.glideContext = glideContext;
            this.model = obj;
            this.transcodeClass = cls;
            this.requestOptions = requestOptions;
            this.overrideWidth = i2;
            this.overrideHeight = i3;
            this.priority = priority;
            this.target = target;
            this.targetListener = requestListener;
            this.requestListeners = list;
            this.requestCoordinator = requestCoordinator;
            this.engine = engine;
            this.animationFactory = transitionFactory;
            this.status = Status.PENDING;
        }
    }

    private boolean isFirstReadyResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
        }
        return invokeV.booleanValue;
    }

    public static boolean listenerCountEquals(SingleRequest<?> singleRequest, SingleRequest<?> singleRequest2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, singleRequest, singleRequest2)) == null) {
            List<RequestListener<?>> list = singleRequest.requestListeners;
            int size = list == null ? 0 : list.size();
            List<RequestListener<?>> list2 = singleRequest2.requestListeners;
            return size == (list2 == null ? 0 : list2.size());
        }
        return invokeLL.booleanValue;
    }

    private Drawable loadDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) {
            return DrawableDecoderCompat.getDrawable(this.glideContext, i2, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
        }
        return (Drawable) invokeI.objValue;
    }

    private void logV(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            String str2 = str + " this: " + this.tag;
        }
    }

    public static int maybeApplySizeMultiplier(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2) : invokeCommon.intValue;
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (requestCoordinator = this.requestCoordinator) == null) {
            return;
        }
        requestCoordinator.onRequestFailed(this);
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (requestCoordinator = this.requestCoordinator) == null) {
            return;
        }
        requestCoordinator.onRequestSuccess(this);
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, glideContext, obj, cls, requestOptions, Integer.valueOf(i2), Integer.valueOf(i3), priority, target, requestListener, list, requestCoordinator, engine, transitionFactory})) == null) {
            SingleRequest<?> acquire = POOL.acquire();
            if (acquire == null) {
                acquire = new SingleRequest();
            }
            acquire.init(context, glideContext, obj, cls, requestOptions, i2, i3, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory);
            return acquire;
        }
        return (SingleRequest) invokeCommon.objValue;
    }

    private void releaseResource(Resource<?> resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, resource) == null) {
            this.engine.release(resource);
            this.resource = null;
        }
    }

    private void setErrorPlaceholder() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = LogTime.getLogTime();
            if (this.model == null) {
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                return;
            }
            Status status = this.status;
            if (status != Status.RUNNING) {
                if (status == Status.COMPLETE) {
                    onResourceReady(this.resource, DataSource.MEMORY_CACHE);
                    return;
                }
                this.status = Status.WAITING_FOR_SIZE;
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    onSizeReady(this.overrideWidth, this.overrideHeight);
                } else {
                    this.target.getSize(this);
                }
                Status status2 = this.status;
                if ((status2 == Status.RUNNING || status2 == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                    this.target.onLoadStarted(getPlaceholderDrawable());
                }
                if (IS_VERBOSE_LOGGABLE) {
                    logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot restart a running request");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Util.assertMainThread();
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            if (this.status == Status.CLEARED) {
                return;
            }
            cancel();
            Resource<R> resource = this.resource;
            if (resource != null) {
                releaseResource(resource);
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.stateVerifier : (StateVerifier) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.status == Status.CLEARED : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.status == Status.COMPLETE : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, request)) == null) {
            if (request instanceof SingleRequest) {
                SingleRequest singleRequest = (SingleRequest) request;
                return this.overrideWidth == singleRequest.overrideWidth && this.overrideHeight == singleRequest.overrideHeight && Util.bothModelsNullEquivalentOrEquals(this.model, singleRequest.model) && this.transcodeClass.equals(singleRequest.transcodeClass) && this.requestOptions.equals(singleRequest.requestOptions) && this.priority == singleRequest.priority && listenerCountEquals(this, singleRequest);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.status == Status.FAILED : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isComplete() : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Status status = this.status;
            return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, glideException) == null) {
            onLoadFailed(glideException, 5);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bumptech.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, resource, dataSource) == null) {
            this.stateVerifier.throwIfRecycled();
            this.loadStatus = null;
            if (resource == null) {
                onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                return;
            }
            Object obj = resource.get();
            if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
                if (!canSetResource()) {
                    releaseResource(resource);
                    this.status = Status.COMPLETE;
                    return;
                }
                onResourceReady(resource, obj, dataSource);
                return;
            }
            releaseResource(resource);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.transcodeClass);
            sb.append(" but instead got ");
            sb.append(obj != null ? obj.getClass() : "");
            sb.append("{");
            sb.append(obj);
            sb.append("} inside Resource{");
            sb.append(resource);
            sb.append("}.");
            sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
            onLoadFailed(new GlideException(sb.toString()));
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.stateVerifier.throwIfRecycled();
            if (IS_VERBOSE_LOGGABLE) {
                logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
            if (this.status != Status.WAITING_FOR_SIZE) {
                return;
            }
            this.status = Status.RUNNING;
            float sizeMultiplier = this.requestOptions.getSizeMultiplier();
            this.width = maybeApplySizeMultiplier(i2, sizeMultiplier);
            this.height = maybeApplySizeMultiplier(i3, sizeMultiplier);
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
            }
            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this);
            if (this.status != Status.RUNNING) {
                this.loadStatus = null;
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            assertNotCallingCallbacks();
            this.context = null;
            this.glideContext = null;
            this.model = null;
            this.transcodeClass = null;
            this.requestOptions = null;
            this.overrideWidth = -1;
            this.overrideHeight = -1;
            this.target = null;
            this.requestListeners = null;
            this.targetListener = null;
            this.requestCoordinator = null;
            this.animationFactory = null;
            this.loadStatus = null;
            this.errorDrawable = null;
            this.placeholderDrawable = null;
            this.fallbackDrawable = null;
            this.width = -1;
            this.height = -1;
            POOL.release(this);
        }
    }

    private void onLoadFailed(GlideException glideException, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65555, this, glideException, i2) == null) {
            this.stateVerifier.throwIfRecycled();
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i2) {
                String str = "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + PreferencesUtil.RIGHT_MOUNT;
                if (logLevel <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                if (this.requestListeners != null) {
                    z = false;
                    for (RequestListener<R> requestListener : this.requestListeners) {
                        z |= requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z = false;
                }
                if (this.targetListener == null || !this.targetListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                notifyLoadFailed();
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, this, resource, r, dataSource) == null) {
            boolean isFirstReadyResource = isFirstReadyResource();
            this.status = Status.COMPLETE;
            this.resource = resource;
            if (this.glideContext.getLogLevel() <= 3) {
                String str = "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms";
            }
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                if (this.requestListeners != null) {
                    z = false;
                    for (RequestListener<R> requestListener : this.requestListeners) {
                        z |= requestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource);
                    }
                } else {
                    z = false;
                }
                if (this.targetListener == null || !this.targetListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource)) {
                    z2 = false;
                }
                if (!(z2 | z)) {
                    this.target.onResourceReady(r, this.animationFactory.build(dataSource, isFirstReadyResource));
                }
                this.isCallingCallbacks = false;
                notifyLoadSuccess();
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }
}
