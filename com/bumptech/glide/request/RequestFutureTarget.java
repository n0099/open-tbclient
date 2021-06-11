package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R>, Runnable {
    public static final Waiter DEFAULT_WAITER = new Waiter();
    public final boolean assertBackgroundThread;
    @Nullable
    public GlideException exception;
    public final int height;
    public boolean isCancelled;
    public boolean loadFailed;
    public final Handler mainHandler;
    @Nullable
    public Request request;
    @Nullable
    public R resource;
    public boolean resultReceived;
    public final Waiter waiter;
    public final int width;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class Waiter {
        public void notifyAll(Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(Handler handler, int i2, int i3) {
        this(handler, i2, i3, true, DEFAULT_WAITER);
    }

    private void clearOnMainThread() {
        this.mainHandler.post(this);
    }

    private synchronized R doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (!this.isCancelled) {
            if (!this.loadFailed) {
                if (this.resultReceived) {
                    return this.resource;
                }
                if (l == null) {
                    this.waiter.waitForTimeout(this, 0L);
                } else if (l.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.waiter.waitForTimeout(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.loadFailed) {
                        if (!this.isCancelled) {
                            if (this.resultReceived) {
                                return this.resource;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.exception);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.exception);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this.isCancelled = true;
        this.waiter.notifyAll(this);
        if (z) {
            clearOnMainThread();
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.isCancelled && !this.resultReceived) {
            z = this.loadFailed;
        }
        return z;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@NonNull R r, @Nullable Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request = this.request;
        if (request != null) {
            request.clear();
            this.request = null;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        this.request = request;
    }

    public RequestFutureTarget(Handler handler, int i2, int i3, boolean z, Waiter waiter) {
        this.mainHandler = handler;
        this.width = i2;
        this.height = i3;
        this.assertBackgroundThread = z;
        this.waiter = waiter;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.loadFailed = true;
        this.exception = glideException;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }
}
