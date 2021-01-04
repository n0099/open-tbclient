package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class MultiModelLoaderFactory {
    private static final Factory DEFAULT_FACTORY = new Factory();
    private static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = new EmptyModelLoader();
    private final Set<Entry<?, ?>> alreadyUsedEntries;
    private final List<Entry<?, ?>> entries;
    private final Factory factory;
    private final Pools.Pool<List<Throwable>> throwableListPool;

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, DEFAULT_FACTORY);
    }

    @VisibleForTesting
    MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull Factory factory) {
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = pool;
        this.factory = factory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        add(cls, cls2, modelLoaderFactory, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        add(cls, cls2, modelLoaderFactory, false);
    }

    private <Model, Data> void add(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        this.entries.add(z ? this.entries.size() : 0, new Entry<>(cls, cls2, modelLoaderFactory));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> remove;
        remove = remove(cls, cls2);
        append(cls, cls2, modelLoaderFactory);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<Entry<?, ?>> it = this.entries.iterator();
        while (it.hasNext()) {
            Entry<?, ?> next = it.next();
            if (next.handles(cls, cls2)) {
                it.remove();
                arrayList.add(getFactory(next));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> build(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry<?, ?> entry : this.entries) {
                if (!this.alreadyUsedEntries.contains(entry) && entry.handles(cls)) {
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
            }
        } catch (Throwable th) {
            this.alreadyUsedEntries.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Entry<?, ?> entry : this.entries) {
            if (!arrayList.contains(entry.dataClass) && entry.handles(cls)) {
                arrayList.add(entry.dataClass);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ModelLoader<Model, Data> emptyModelLoader;
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Entry<?, ?> entry : this.entries) {
                if (this.alreadyUsedEntries.contains(entry)) {
                    z = true;
                } else if (entry.handles(cls, cls2)) {
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                emptyModelLoader = this.factory.build(arrayList, this.throwableListPool);
            } else if (arrayList.size() == 1) {
                emptyModelLoader = (ModelLoader) arrayList.get(0);
            } else if (z) {
                emptyModelLoader = emptyModelLoader();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.alreadyUsedEntries.clear();
            throw th;
        }
        return emptyModelLoader;
    }

    @NonNull
    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(@NonNull Entry<?, ?> entry) {
        return (ModelLoaderFactory<Model, Data>) entry.factory;
    }

    @NonNull
    private <Model, Data> ModelLoader<Model, Data> build(@NonNull Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.checkNotNull(entry.factory.build(this));
    }

    @NonNull
    private static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        return (ModelLoader<Model, Data>) EMPTY_MODEL_LOADER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Entry<Model, Data> {
        final Class<Data> dataClass;
        final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        private final Class<Model> modelClass;

        public Entry(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.modelClass = cls;
            this.dataClass = cls2;
            this.factory = modelLoaderFactory;
        }

        public boolean handles(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return handles(cls) && this.dataClass.isAssignableFrom(cls2);
        }

        public boolean handles(@NonNull Class<?> cls) {
            return this.modelClass.isAssignableFrom(cls);
        }
    }

    /* loaded from: classes5.dex */
    static class Factory {
        Factory() {
        }

        @NonNull
        public <Model, Data> MultiModelLoader<Model, Data> build(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    /* loaded from: classes5.dex */
    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        @Nullable
        public ModelLoader.LoadData<Object> buildLoadData(@NonNull Object obj, int i, int i2, @NonNull Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(@NonNull Object obj) {
            return false;
        }
    }
}
