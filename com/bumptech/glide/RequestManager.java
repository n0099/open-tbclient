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
    public static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    public static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
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
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* loaded from: classes7.dex */
    public static class ClearTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public ClearTarget(@NonNull View view2) {
            super(view2);
        }
    }

    /* loaded from: classes7.dex */
    public class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        @GuardedBy("RequestManager.this")
        public final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(@NonNull RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.requestTracker.restartRequests();
                }
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
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

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.targetTracker = new TargetTracker();
        this.addSelfToLifecycle = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.lifecycle.addListener(requestManager);
            }
        };
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        this.connectivityMonitor = connectivityMonitorFactory.build(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
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
        boolean untrack = untrack(target);
        Request request = target.getRequest();
        if (!untrack && !this.glide.removeFromManagers(target) && request != null) {
            target.setRequest(null);
            request.clear();
        }
    }

    private synchronized void updateRequestOptions(@NonNull RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    public void clear(@NonNull View view2) {
        clear(new ClearTarget(view2));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    public synchronized void setRequestOptions(@NonNull RequestOptions requestOptions) {
        this.requestOptions = requestOptions.mo83clone().autoClone();
    }

    public synchronized boolean untrack(@NonNull Target<?> target) {
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

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((BaseRequestOptions<?>) DECODE_TYPE_BITMAP);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((BaseRequestOptions<?>) DECODE_TYPE_GIF);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.isPaused();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.pauseAllRequests();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        for (RequestManager requestManager : this.treeNode.getDescendants()) {
            requestManager.pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        for (RequestManager requestManager : this.treeNode.getDescendants()) {
            requestManager.pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager requestManager : this.treeNode.getDescendants()) {
            requestManager.resumeRequests();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    public void clear(@Nullable Target<?> target) {
        if (target == null) {
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
        return asDrawable().load(drawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Uri uri) {
        return asDrawable().load(uri);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable File file) {
        return asDrawable().load(file);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable @DrawableRes @RawRes Integer num) {
        return asDrawable().load(num);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable String str) {
        return asDrawable().load(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public RequestBuilder<Drawable> load(@Nullable URL url) {
        return asDrawable().load(url);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable byte[] bArr) {
        return asDrawable().load(bArr);
    }

    public synchronized void track(@NonNull Target<?> target, @NonNull Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }
}
