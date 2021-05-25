package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;
/* loaded from: classes5.dex */
public class ModelCache<A, B> {
    public static final int DEFAULT_SIZE = 250;
    public final LruCache<ModelKey<A>, B> cache;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static final class ModelKey<A> {
        public static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        public int height;
        public A model;
        public int width;

        public static <A> ModelKey<A> get(A a2, int i2, int i3) {
            ModelKey<A> modelKey;
            synchronized (KEY_QUEUE) {
                modelKey = (ModelKey<A>) KEY_QUEUE.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.init(a2, i2, i3);
            return modelKey;
        }

        private void init(A a2, int i2, int i3) {
            this.model = a2;
            this.width = i2;
            this.height = i3;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ModelKey) {
                ModelKey modelKey = (ModelKey) obj;
                return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            synchronized (KEY_QUEUE) {
                KEY_QUEUE.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250L);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A a2, int i2, int i3) {
        ModelKey<A> modelKey = ModelKey.get(a2, i2, i3);
        B b2 = this.cache.get(modelKey);
        modelKey.release();
        return b2;
    }

    public void put(A a2, int i2, int i3, B b2) {
        this.cache.put(ModelKey.get(a2, i2, i3), b2);
    }

    public ModelCache(long j) {
        this.cache = new LruCache<ModelKey<A>, B>(j) { // from class: com.bumptech.glide.load.model.ModelCache.1
            @Override // com.bumptech.glide.util.LruCache
            public /* bridge */ /* synthetic */ void onItemEvicted(@NonNull Object obj, @Nullable Object obj2) {
                onItemEvicted((ModelKey) ((ModelKey) obj), (ModelKey<A>) obj2);
            }

            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b2) {
                modelKey.release();
            }
        };
    }
}
