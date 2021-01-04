package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
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
public final class SingleRequest<R> implements Request, ResourceCallback, SizeReadyCallback, FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private TransitionFactory<? super R> animationFactory;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    @Nullable
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    @Nullable
    private List<RequestListener<R>> requestListeners;
    private RequestOptions requestOptions;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    @Nullable
    private final String tag;
    private Target<R> target;
    @Nullable
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;
    private static final Pools.Pool<SingleRequest<?>> POOL = FactoryPools.simple(150, new FactoryPools.Factory<SingleRequest<?>>() { // from class: com.bumptech.glide.request.SingleRequest.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    });
    private static final String TAG = "Request";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<R> singleRequest = (SingleRequest<R>) POOL.acquire();
        if (singleRequest == null) {
            singleRequest = new SingleRequest<>();
        }
        singleRequest.init(context, glideContext, obj, cls, requestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory);
        return singleRequest;
    }

    SingleRequest() {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void init(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj;
        this.transcodeClass = cls;
        this.requestOptions = requestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.status = Status.PENDING;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
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
        } else if (this.status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else {
            if (this.status == Status.COMPLETE) {
                onResourceReady(this.resource, DataSource.MEMORY_CACHE);
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
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        if (this.loadStatus != null) {
            this.loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Util.assertMainThread();
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        if (this.status != Status.CLEARED) {
            cancel();
            if (this.resource != null) {
                releaseResource(this.resource);
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    private void releaseResource(Resource<?> resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        return this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        return this.status == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            this.errorDrawable = this.requestOptions.getErrorPlaceholder();
            if (this.errorDrawable == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            this.placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            if (this.placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            this.fallbackDrawable = this.requestOptions.getFallbackDrawable();
            if (this.fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(@DrawableRes int i) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
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
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        this.stateVerifier.throwIfRecycled();
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
            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this);
            if (this.status != Status.RUNNING) {
                this.loadStatus = null;
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(i * f);
    }

    private boolean canSetResource() {
        return this.requestCoordinator == null || this.requestCoordinator.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        return this.requestCoordinator == null || this.requestCoordinator.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        return this.requestCoordinator == null || this.requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        return this.requestCoordinator == null || !this.requestCoordinator.isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.onRequestFailed(this);
        }
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
        if (obj == null || !this.transcodeClass.isAssignableFrom(obj.getClass())) {
            releaseResource(resource);
            onLoadFailed(new GlideException("Expected to receive an object of " + this.transcodeClass + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "} inside Resource{" + resource + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (!canSetResource()) {
            releaseResource(resource);
            this.status = Status.COMPLETE;
        } else {
            onResourceReady(resource, obj, dataSource);
        }
    }

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
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
            if (!((this.targetListener != null && this.targetListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource)) | z)) {
                this.target.onResourceReady(r, this.animationFactory.build(dataSource, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        int logLevel = this.glideContext.getLogLevel();
        if (logLevel <= i) {
            Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
            if (logLevel <= 4) {
                glideException.logRootCauses(GLIDE_TAG);
            }
        }
        this.loadStatus = null;
        this.status = Status.FAILED;
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
            if (!((this.targetListener != null && this.targetListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) | z)) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            notifyLoadFailed();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (request instanceof SingleRequest) {
            SingleRequest singleRequest = (SingleRequest) request;
            return this.overrideWidth == singleRequest.overrideWidth && this.overrideHeight == singleRequest.overrideHeight && Util.bothModelsNullEquivalentOrEquals(this.model, singleRequest.model) && this.transcodeClass.equals(singleRequest.transcodeClass) && this.requestOptions.equals(singleRequest.requestOptions) && this.priority == singleRequest.priority && listenerCountEquals(this, singleRequest);
        }
        return false;
    }

    private static boolean listenerCountEquals(SingleRequest<?> singleRequest, SingleRequest<?> singleRequest2) {
        return (((SingleRequest) singleRequest).requestListeners == null ? 0 : ((SingleRequest) singleRequest).requestListeners.size()) == (((SingleRequest) singleRequest2).requestListeners == null ? 0 : ((SingleRequest) singleRequest2).requestListeners.size());
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }
}
