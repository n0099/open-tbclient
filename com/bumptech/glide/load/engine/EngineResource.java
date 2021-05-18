package com.bumptech.glide.load.engine;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes4.dex */
public class EngineResource<Z> implements Resource<Z> {
    public int acquired;
    public final boolean isCacheable;
    public final boolean isRecyclable;
    public boolean isRecycled;
    public Key key;
    public ResourceListener listener;
    public final Resource<Z> resource;

    /* loaded from: classes4.dex */
    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource, boolean z, boolean z2) {
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isCacheable = z;
        this.isRecyclable = z2;
    }

    public void acquire() {
        if (!this.isRecycled) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                this.acquired++;
                return;
            }
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        throw new IllegalStateException("Cannot acquire a recycled resource");
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.resource.get();
    }

    public Resource<Z> getResource() {
        return this.resource;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isCacheable() {
        return this.isCacheable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        if (this.acquired <= 0) {
            if (!this.isRecycled) {
                this.isRecycled = true;
                if (this.isRecyclable) {
                    this.resource.recycle();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }

    public void release() {
        if (this.acquired > 0) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                int i2 = this.acquired - 1;
                this.acquired = i2;
                if (i2 == 0) {
                    this.listener.onResourceReleased(this.key, this);
                    return;
                }
                return;
            }
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }

    public void setResourceListener(Key key, ResourceListener resourceListener) {
        this.key = key;
        this.listener = resourceListener;
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.isCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
