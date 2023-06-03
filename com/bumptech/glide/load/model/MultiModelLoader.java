package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    public final Pools.Pool<List<Throwable>> exceptionListPool;
    public final List<ModelLoader<Model, Data>> modelLoaders;

    /* loaded from: classes9.dex */
    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        public DataFetcher.DataCallback<? super Data> callback;
        public int currentIndex;
        @Nullable
        public List<Throwable> exceptions;
        public final List<DataFetcher<Data>> fetchers;
        public boolean isCancelled;
        public Priority priority;
        public final Pools.Pool<List<Throwable>> throwableListPool;

        public MultiFetcher(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.throwableListPool = pool;
            Preconditions.checkNotEmpty(list);
            this.fetchers = list;
            this.currentIndex = 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.priority = priority;
            this.callback = dataCallback;
            this.exceptions = this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(priority, this);
            if (this.isCancelled) {
                cancel();
            }
        }

        private void startNextOrFail() {
            if (this.isCancelled) {
                return;
            }
            if (this.currentIndex < this.fetchers.size() - 1) {
                this.currentIndex++;
                loadData(this.priority, this.callback);
                return;
            }
            Preconditions.checkNotNull(this.exceptions);
            this.callback.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.exceptions)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            for (DataFetcher<Data> dataFetcher : this.fetchers) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> list = this.exceptions;
            if (list != null) {
                this.throwableListPool.release(list);
            }
            this.exceptions = null;
            for (DataFetcher<Data> dataFetcher : this.fetchers) {
                dataFetcher.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@Nullable Data data) {
            if (data != null) {
                this.callback.onDataReady(data);
            } else {
                startNextOrFail();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@NonNull Exception exc) {
            ((List) Preconditions.checkNotNull(this.exceptions)).add(exc);
            startNextOrFail();
        }
    }

    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.modelLoaders = list;
        this.exceptionListPool = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        ModelLoader.LoadData<Data> buildLoadData;
        int size = this.modelLoaders.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader<Model, Data> modelLoader = this.modelLoaders.get(i3);
            if (modelLoader.handles(model) && (buildLoadData = modelLoader.buildLoadData(model, i, i2, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList.add(buildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.exceptionListPool));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        for (ModelLoader<Model, Data> modelLoader : this.modelLoaders) {
            if (modelLoader.handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + '}';
    }
}
