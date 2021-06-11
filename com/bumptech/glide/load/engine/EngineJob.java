package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    public static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    public static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    public static final int MSG_CANCELLED = 3;
    public static final int MSG_COMPLETE = 1;
    public static final int MSG_EXCEPTION = 2;
    public final GlideExecutor animationExecutor;
    public final List<ResourceCallback> cbs;
    public DataSource dataSource;
    public DecodeJob<R> decodeJob;
    public final GlideExecutor diskCacheExecutor;
    public EngineResource<?> engineResource;
    public final EngineResourceFactory engineResourceFactory;
    public GlideException exception;
    public boolean hasLoadFailed;
    public boolean hasResource;
    public List<ResourceCallback> ignoredCallbacks;
    public boolean isCacheable;
    public volatile boolean isCancelled;
    public Key key;
    public final EngineJobListener listener;
    public boolean onlyRetrieveFromCache;
    public final Pools.Pool<EngineJob<?>> pool;
    public Resource<?> resource;
    public final GlideExecutor sourceExecutor;
    public final GlideExecutor sourceUnlimitedExecutor;
    public final StateVerifier stateVerifier;
    public boolean useAnimationPool;
    public boolean useUnlimitedSourceGeneratorPool;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class EngineResourceFactory {
        public <R> EngineResource<R> build(Resource<R> resource, boolean z) {
            return new EngineResource<>(resource, z, true);
        }
    }

    /* loaded from: classes6.dex */
    public static class MainThreadCallback implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            EngineJob engineJob = (EngineJob) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                engineJob.handleResultOnMainThread();
            } else if (i2 == 2) {
                engineJob.handleExceptionOnMainThread();
            } else if (i2 == 3) {
                engineJob.handleCancelledOnMainThread();
            } else {
                throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            return true;
        }
    }

    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, DEFAULT_FACTORY);
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new ArrayList(2);
        }
        if (this.ignoredCallbacks.contains(resourceCallback)) {
            return;
        }
        this.ignoredCallbacks.add(resourceCallback);
    }

    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool) {
            return this.sourceUnlimitedExecutor;
        }
        return this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        List<ResourceCallback> list = this.ignoredCallbacks;
        return list != null && list.contains(resourceCallback);
    }

    private void release(boolean z) {
        Util.assertMainThread();
        this.cbs.clear();
        this.key = null;
        this.engineResource = null;
        this.resource = null;
        List<ResourceCallback> list = this.ignoredCallbacks;
        if (list != null) {
            list.clear();
        }
        this.hasLoadFailed = false;
        this.isCancelled = false;
        this.hasResource = false;
        this.decodeJob.release(z);
        this.decodeJob = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release(this);
    }

    public void addCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        this.stateVerifier.throwIfRecycled();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } else if (this.hasLoadFailed) {
            resourceCallback.onLoadFailed(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    public void cancel() {
        if (this.hasLoadFailed || this.hasResource || this.isCancelled) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.listener.onEngineJobCancelled(this, this.key);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public void handleCancelledOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            this.listener.onEngineJobCancelled(this, this.key);
            release(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    public void handleExceptionOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            release(false);
        } else if (!this.cbs.isEmpty()) {
            if (!this.hasLoadFailed) {
                this.hasLoadFailed = true;
                this.listener.onEngineJobComplete(this, this.key, null);
                for (ResourceCallback resourceCallback : this.cbs) {
                    if (!isInIgnoredCallbacks(resourceCallback)) {
                        resourceCallback.onLoadFailed(this.exception);
                    }
                }
                release(false);
                return;
            }
            throw new IllegalStateException("Already failed once");
        } else {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
    }

    public void handleResultOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            this.resource.recycle();
            release(false);
        } else if (!this.cbs.isEmpty()) {
            if (!this.hasResource) {
                EngineResource<?> build = this.engineResourceFactory.build(this.resource, this.isCacheable);
                this.engineResource = build;
                this.hasResource = true;
                build.acquire();
                this.listener.onEngineJobComplete(this, this.key, this.engineResource);
                int size = this.cbs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ResourceCallback resourceCallback = this.cbs.get(i2);
                    if (!isInIgnoredCallbacks(resourceCallback)) {
                        this.engineResource.acquire();
                        resourceCallback.onResourceReady(this.engineResource, this.dataSource);
                    }
                }
                this.engineResource.release();
                release(false);
                return;
            }
            throw new IllegalStateException("Already have resource");
        } else {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
    }

    @VisibleForTesting
    public EngineJob<R> init(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = key;
        this.isCacheable = z;
        this.useUnlimitedSourceGeneratorPool = z2;
        this.useAnimationPool = z3;
        this.onlyRetrieveFromCache = z4;
        return this;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        this.exception = glideException;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.bumptech.glide.load.engine.Resource<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        this.resource = resource;
        this.dataSource = dataSource;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public void removeCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        this.stateVerifier.throwIfRecycled();
        if (!this.hasResource && !this.hasLoadFailed) {
            this.cbs.remove(resourceCallback);
            if (this.cbs.isEmpty()) {
                cancel();
                return;
            }
            return;
        }
        addIgnoredCallback(resourceCallback);
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob) {
        getActiveSourceExecutor().execute(decodeJob);
    }

    public void start(DecodeJob<R> decodeJob) {
        GlideExecutor activeSourceExecutor;
        this.decodeJob = decodeJob;
        if (decodeJob.willDecodeFromCache()) {
            activeSourceExecutor = this.diskCacheExecutor;
        } else {
            activeSourceExecutor = getActiveSourceExecutor();
        }
        activeSourceExecutor.execute(decodeJob);
    }

    @VisibleForTesting
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.cbs = new ArrayList(2);
        this.stateVerifier = StateVerifier.newInstance();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.listener = engineJobListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }
}
