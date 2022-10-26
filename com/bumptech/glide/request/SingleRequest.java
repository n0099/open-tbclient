package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
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
import com.bumptech.glide.GlideBuilder;
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
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class SingleRequest implements Request, SizeReadyCallback, ResourceCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GLIDE_TAG = "Glide";
    public static final boolean IS_VERBOSE_LOGGABLE;
    public static final String TAG = "Request";
    public transient /* synthetic */ FieldHolder $fh;
    public final TransitionFactory animationFactory;
    public final Executor callbackExecutor;
    public final Context context;
    public volatile Engine engine;
    public Drawable errorDrawable;
    public Drawable fallbackDrawable;
    public final GlideContext glideContext;
    public int height;
    public boolean isCallingCallbacks;
    public Engine.LoadStatus loadStatus;
    public final Object model;
    public final int overrideHeight;
    public final int overrideWidth;
    public Drawable placeholderDrawable;
    public final Priority priority;
    public final RequestCoordinator requestCoordinator;
    public final List requestListeners;
    public final Object requestLock;
    public final BaseRequestOptions requestOptions;
    public RuntimeException requestOrigin;
    public Resource resource;
    public long startTime;
    public final StateVerifier stateVerifier;
    public Status status;
    public final String tag;
    public final Target target;
    public final RequestListener targetListener;
    public final Class transcodeClass;
    public int width;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public final class Status {
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

        public Status(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Status) Enum.valueOf(Status.class, str);
            }
            return (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Status[]) $VALUES.clone();
            }
            return (Status[]) invokeV.objValue;
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
        IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    private void assertNotCallingCallbacks() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, this) != null) || !this.isCallingCallbacks) {
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    private boolean canNotifyCleared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean canNotifyStatusChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean canSetResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
                return false;
            }
            return true;
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

    private boolean isFirstReadyResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            RequestCoordinator requestCoordinator = this.requestCoordinator;
            if (requestCoordinator != null && requestCoordinator.getRoot().isAnyResourceSet()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && (requestCoordinator = this.requestCoordinator) != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && (requestCoordinator = this.requestCoordinator) != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    private void setErrorPlaceholder() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65555, this) != null) || !canNotifyStatusChanged()) {
            return;
        }
        Drawable drawable = null;
        if (this.model == null) {
            drawable = getFallbackDrawable();
        }
        if (drawable == null) {
            drawable = getErrorDrawable();
        }
        if (drawable == null) {
            drawable = getPlaceholderDrawable();
        }
        this.target.onLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.stateVerifier.throwIfRecycled();
            return this.requestLock;
        }
        return invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.requestLock) {
                if (this.status == Status.COMPLETE) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.requestLock) {
                if (this.status == Status.CLEARED) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.requestLock) {
                if (this.status == Status.COMPLETE) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.requestLock) {
                if (this.status != Status.RUNNING && this.status != Status.WAITING_FOR_SIZE) {
                    z = false;
                }
                z = true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this.requestLock) {
                if (isRunning()) {
                    clear();
                }
            }
        }
    }

    public SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i, int i2, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, glideContext, obj, obj2, cls, baseRequestOptions, Integer.valueOf(i), Integer.valueOf(i2), priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (IS_VERBOSE_LOGGABLE) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.tag = str;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
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

    private Drawable loadDrawable(int i) {
        InterceptResult invokeI;
        Resources.Theme theme;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            if (this.requestOptions.getTheme() != null) {
                theme = this.requestOptions.getTheme();
            } else {
                theme = this.context.getTheme();
            }
            return DrawableDecoderCompat.getDrawable(this.glideContext, i, theme);
        }
        return (Drawable) invokeI.objValue;
    }

    private void logV(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            Log.v(TAG, str + " this: " + this.tag);
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, glideException) == null) {
            onLoadFailed(glideException, 5);
        }
    }

    public static int maybeApplySizeMultiplier(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            if (i != Integer.MIN_VALUE) {
                return Math.round(f * i);
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static SingleRequest obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i, int i2, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, glideContext, obj, obj2, cls, baseRequestOptions, Integer.valueOf(i), Integer.valueOf(i2), priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor})) == null) {
            return new SingleRequest(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
        }
        return (SingleRequest) invokeCommon.objValue;
    }

    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, this, glideException, i) == null) {
            this.stateVerifier.throwIfRecycled();
            synchronized (this.requestLock) {
                glideException.setOrigin(this.requestOrigin);
                int logLevel = this.glideContext.getLogLevel();
                if (logLevel <= i) {
                    Log.w("Glide", "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + PreferencesUtil.RIGHT_MOUNT, glideException);
                    if (logLevel <= 4) {
                        glideException.logRootCauses("Glide");
                    }
                }
                this.loadStatus = null;
                this.status = Status.FAILED;
                boolean z2 = true;
                this.isCallingCallbacks = true;
                if (this.requestListeners != null) {
                    z = false;
                    for (RequestListener requestListener : this.requestListeners) {
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
            }
        }
    }

    private void onResourceReady(Resource resource, Object obj, DataSource dataSource, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{resource, obj, dataSource, Boolean.valueOf(z)}) == null) {
            boolean isFirstReadyResource = isFirstReadyResource();
            this.status = Status.COMPLETE;
            this.resource = resource;
            if (this.glideContext.getLogLevel() <= 3) {
                Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
            }
            boolean z3 = true;
            this.isCallingCallbacks = true;
            try {
                if (this.requestListeners != null) {
                    z2 = false;
                    for (RequestListener requestListener : this.requestListeners) {
                        z2 |= requestListener.onResourceReady(obj, this.model, this.target, dataSource, isFirstReadyResource);
                    }
                } else {
                    z2 = false;
                }
                if (this.targetListener == null || !this.targetListener.onResourceReady(obj, this.model, this.target, dataSource, isFirstReadyResource)) {
                    z3 = false;
                }
                if (!(z3 | z2)) {
                    this.target.onResourceReady(obj, this.animationFactory.build(dataSource, isFirstReadyResource));
                }
                this.isCallingCallbacks = false;
                notifyLoadSuccess();
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.requestLock) {
                assertNotCallingCallbacks();
                this.stateVerifier.throwIfRecycled();
                this.startTime = LogTime.getLogTime();
                if (this.model == null) {
                    if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                        this.width = this.overrideWidth;
                        this.height = this.overrideHeight;
                    }
                    if (getFallbackDrawable() == null) {
                        i = 5;
                    } else {
                        i = 3;
                    }
                    onLoadFailed(new GlideException("Received null model"), i);
                } else if (this.status != Status.RUNNING) {
                    if (this.status == Status.COMPLETE) {
                        onResourceReady(this.resource, DataSource.MEMORY_CACHE, false);
                        return;
                    }
                    this.status = Status.WAITING_FOR_SIZE;
                    if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                        onSizeReady(this.overrideWidth, this.overrideHeight);
                    } else {
                        this.target.getSize(this);
                    }
                    if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                        this.target.onLoadStarted(getPlaceholderDrawable());
                    }
                    if (IS_VERBOSE_LOGGABLE) {
                        logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
                    }
                } else {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.requestLock) {
                assertNotCallingCallbacks();
                this.stateVerifier.throwIfRecycled();
                if (this.status == Status.CLEARED) {
                    return;
                }
                cancel();
                Resource resource = null;
                if (this.resource != null) {
                    Resource resource2 = this.resource;
                    this.resource = null;
                    resource = resource2;
                }
                if (canNotifyCleared()) {
                    this.target.onLoadCleared(getPlaceholderDrawable());
                }
                this.status = Status.CLEARED;
                if (resource != null) {
                    this.engine.release(resource);
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        InterceptResult invokeL;
        int i;
        int i2;
        Object obj;
        Class cls;
        BaseRequestOptions baseRequestOptions;
        Priority priority;
        int i3;
        int i4;
        int i5;
        Object obj2;
        Class cls2;
        BaseRequestOptions baseRequestOptions2;
        Priority priority2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, request)) == null) {
            if (!(request instanceof SingleRequest)) {
                return false;
            }
            synchronized (this.requestLock) {
                i = this.overrideWidth;
                i2 = this.overrideHeight;
                obj = this.model;
                cls = this.transcodeClass;
                baseRequestOptions = this.requestOptions;
                priority = this.priority;
                if (this.requestListeners != null) {
                    i3 = this.requestListeners.size();
                } else {
                    i3 = 0;
                }
            }
            SingleRequest singleRequest = (SingleRequest) request;
            synchronized (singleRequest.requestLock) {
                i4 = singleRequest.overrideWidth;
                i5 = singleRequest.overrideHeight;
                obj2 = singleRequest.model;
                cls2 = singleRequest.transcodeClass;
                baseRequestOptions2 = singleRequest.requestOptions;
                priority2 = singleRequest.priority;
                if (singleRequest.requestListeners != null) {
                    i6 = singleRequest.requestListeners.size();
                } else {
                    i6 = 0;
                }
            }
            if (i == i4 && i2 == i5 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && i3 == i6) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r6 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        r5.engine.release(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
        if (r6 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
        r5.engine.release(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b8, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResourceReady(Resource resource, DataSource dataSource, boolean z) {
        Object obj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, resource, dataSource, z) == null) {
            this.stateVerifier.throwIfRecycled();
            Resource resource2 = null;
            try {
                synchronized (this.requestLock) {
                    try {
                        this.loadStatus = null;
                        if (resource == null) {
                            onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                            return;
                        }
                        Object obj2 = resource.get();
                        try {
                            if (obj2 != null && this.transcodeClass.isAssignableFrom(obj2.getClass())) {
                                if (!canSetResource()) {
                                    this.resource = null;
                                    this.status = Status.COMPLETE;
                                } else {
                                    onResourceReady(resource, obj2, dataSource, z);
                                    return;
                                }
                            }
                            this.resource = null;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Expected to receive an object of ");
                            sb.append(this.transcodeClass);
                            sb.append(" but instead got ");
                            if (obj2 != null) {
                                obj = obj2.getClass();
                            } else {
                                obj = "";
                            }
                            sb.append(obj);
                            sb.append("{");
                            sb.append(obj2);
                            sb.append("} inside Resource{");
                            sb.append(resource);
                            sb.append("}.");
                            if (obj2 != null) {
                                str = "";
                            } else {
                                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                            }
                            sb.append(str);
                            onLoadFailed(new GlideException(sb.toString()));
                        } catch (Throwable th) {
                            resource2 = resource;
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                if (resource2 != null) {
                    this.engine.release(resource2);
                }
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0107 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        ?? r21;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r21 = 1048586;
            if (interceptable.invokeII(1048586, this, i, i2) != null) {
                return;
            }
        }
        this.stateVerifier.throwIfRecycled();
        Object obj = this.requestLock;
        synchronized (obj) {
            try {
                try {
                    if (IS_VERBOSE_LOGGABLE) {
                        logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    if (this.status == Status.WAITING_FOR_SIZE) {
                        this.status = Status.RUNNING;
                        float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                        this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (IS_VERBOSE_LOGGABLE) {
                            logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                        }
                        r21 = obj;
                        try {
                            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                            if (this.status != Status.RUNNING) {
                                this.loadStatus = null;
                            }
                            if (IS_VERBOSE_LOGGABLE) {
                                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r21 = obj;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }
}
