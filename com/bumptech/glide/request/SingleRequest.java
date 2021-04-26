package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes5.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    public static final String GLIDE_TAG = "Glide";
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
    public static final Pools.Pool<SingleRequest<?>> POOL = FactoryPools.simple(150, new FactoryPools.Factory<SingleRequest<?>>() { // from class: com.bumptech.glide.request.SingleRequest.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    });
    public static final String TAG = "Request";
    public static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    /* loaded from: classes5.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest() {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private void init(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
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

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    public static boolean listenerCountEquals(SingleRequest<?> singleRequest, SingleRequest<?> singleRequest2) {
        List<RequestListener<?>> list = singleRequest.requestListeners;
        int size = list == null ? 0 : list.size();
        List<RequestListener<?>> list2 = singleRequest2.requestListeners;
        return size == (list2 == null ? 0 : list2.size());
    }

    private Drawable loadDrawable(@DrawableRes int i2) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, i2, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    public static int maybeApplySizeMultiplier(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<?> acquire = POOL.acquire();
        if (acquire == null) {
            acquire = new SingleRequest();
        }
        acquire.init(context, glideContext, obj, cls, requestOptions, i2, i3, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory);
        return acquire;
    }

    private void releaseResource(Resource<?> resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
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

    @Override // com.bumptech.glide.request.Request
    public void clear() {
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

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        return this.status == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (request instanceof SingleRequest) {
            SingleRequest singleRequest = (SingleRequest) request;
            return this.overrideWidth == singleRequest.overrideWidth && this.overrideHeight == singleRequest.overrideHeight && Util.bothModelsNullEquivalentOrEquals(this.model, singleRequest.model) && this.transcodeClass.equals(singleRequest.transcodeClass) && this.requestOptions.equals(singleRequest.requestOptions) && this.priority == singleRequest.priority && listenerCountEquals(this, singleRequest);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        return this.status == Status.FAILED;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Status status = this.status;
        return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bumptech.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource, DataSource dataSource) {
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
        sb.append(StringUtil.ARRAY_START);
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(resource);
        sb.append("}.");
        sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        onLoadFailed(new GlideException(sb.toString()));
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i2, int i3) {
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

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
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

    private void onLoadFailed(GlideException glideException, int i2) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        int logLevel = this.glideContext.getLogLevel();
        if (logLevel <= i2) {
            Log.w("Glide", "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
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

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
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
