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
/* loaded from: classes6.dex */
public class RequestManager implements LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    public static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    public static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
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

    /* loaded from: classes6.dex */
    public static class ClearTarget extends ViewTarget<View, Object> {
        public ClearTarget(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    /* loaded from: classes6.dex */
    public static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        public final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(@NonNull RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if (z) {
                this.requestTracker.restartRequests();
            }
        }
    }

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    private void untrackOrDelegate(@NonNull Target<?> target) {
        if (untrack(target) || this.glide.removeFromManagers(target) || target.getRequest() == null) {
            return;
        }
        Request request = target.getRequest();
        target.setRequest(null);
        request.clear();
    }

    private void updateRequestOptions(@NonNull RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    @NonNull
    public RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public void clear(@NonNull View view) {
        clear(new ClearTarget(view));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    public RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
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

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    public void pauseAllRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseAllRequests();
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        pauseRequests();
        for (RequestManager requestManager : this.treeNode.getDescendants()) {
            requestManager.pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager requestManager : this.treeNode.getDescendants()) {
            requestManager.resumeRequests();
        }
    }

    @NonNull
    public RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setRequestOptions(@NonNull RequestOptions requestOptions) {
        this.requestOptions = requestOptions.m33clone().autoClone();
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    public void track(@NonNull Target<?> target, @NonNull Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    public boolean untrack(@NonNull Target<?> target) {
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

    public void clear(@Nullable final Target<?> target) {
        if (target == null) {
            return;
        }
        if (Util.isOnMainThread()) {
            untrackOrDelegate(target);
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.bumptech.glide.RequestManager.2
                @Override // java.lang.Runnable
                public void run() {
                    RequestManager.this.clear(target);
                }
            });
        }
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
        return asDrawable().load(bitmap);
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
    public RequestBuilder<Drawable> load(@Nullable String str) {
        return asDrawable().load(str);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }
}
