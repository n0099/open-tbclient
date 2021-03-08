package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;
/* loaded from: classes14.dex */
public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    private volatile Request full;
    @GuardedBy("requestLock")
    private boolean isRunningDuringBegin;
    @Nullable
    private final RequestCoordinator parent;
    private final Object requestLock;
    private volatile Request thumb;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState fullState = RequestCoordinator.RequestState.CLEARED;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState thumbState = RequestCoordinator.RequestState.CLEARED;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanSetImage() && (request.equals(this.full) || this.fullState != RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    @GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        return this.parent == null || this.parent.canSetImage(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyCleared() && request.equals(this.full) && this.fullState != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        return this.parent == null || this.parent.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        return this.parent == null || this.parent.canNotifyStatusChanged(this);
    }

    @Override // com.bumptech.glide.request.Request, com.bumptech.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.thumb.isAnyResourceSet() || this.full.isAnyResourceSet();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        synchronized (this.requestLock) {
            if (request.equals(this.thumb)) {
                this.thumbState = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.fullState = RequestCoordinator.RequestState.SUCCESS;
            if (this.parent != null) {
                this.parent.onRequestSuccess(this);
            }
            if (!this.thumbState.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.requestLock) {
            if (!request.equals(this.full)) {
                this.thumbState = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.fullState = RequestCoordinator.RequestState.FAILED;
            if (this.parent != null) {
                this.parent.onRequestFailed(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bumptech.glide.request.RequestCoordinator] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        ?? r2;
        synchronized (this.requestLock) {
            RequestCoordinator requestCoordinator = this.parent;
            this = this;
            if (requestCoordinator != null) {
                r2 = this.parent.getRoot();
            }
        }
        return r2;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = true;
            if (this.fullState != RequestCoordinator.RequestState.SUCCESS && this.thumbState != RequestCoordinator.RequestState.RUNNING) {
                this.thumbState = RequestCoordinator.RequestState.RUNNING;
                this.thumb.begin();
            }
            if (this.isRunningDuringBegin && this.fullState != RequestCoordinator.RequestState.RUNNING) {
                this.fullState = RequestCoordinator.RequestState.RUNNING;
                this.full.begin();
            }
            this.isRunningDuringBegin = false;
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = false;
            this.fullState = RequestCoordinator.RequestState.CLEARED;
            this.thumbState = RequestCoordinator.RequestState.CLEARED;
            this.thumb.clear();
            this.full.clear();
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (!this.thumbState.isComplete()) {
                this.thumbState = RequestCoordinator.RequestState.PAUSED;
                this.thumb.pause();
            }
            if (!this.fullState.isComplete()) {
                this.fullState = RequestCoordinator.RequestState.PAUSED;
                this.full.pause();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (request instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
            if (this.full == null) {
                if (thumbnailRequestCoordinator.full != null) {
                    return false;
                }
            } else if (!this.full.isEquivalentTo(thumbnailRequestCoordinator.full)) {
                return false;
            }
            if (this.thumb == null) {
                if (thumbnailRequestCoordinator.thumb != null) {
                    return false;
                }
            } else if (!this.thumb.isEquivalentTo(thumbnailRequestCoordinator.thumb)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
