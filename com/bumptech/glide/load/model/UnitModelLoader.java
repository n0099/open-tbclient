package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
/* loaded from: classes5.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {
    private static final UnitModelLoader<?> INSTANCE = new UnitModelLoader<>();

    public static <T> UnitModelLoader<T> getInstance() {
        return (UnitModelLoader<T>) INSTANCE;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Model> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        return true;
    }

    /* loaded from: classes5.dex */
    private static class UnitFetcher<Model> implements DataFetcher<Model> {
        private final Model resource;

        UnitFetcher(Model model) {
            this.resource = model;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: Model, ? super Model */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.onDataReady((Model) this.resource);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Model> getDataClass() {
            return (Class<Model>) this.resource.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes5.dex */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {
        private static final Factory<?> FACTORY = new Factory<>();

        public static <T> Factory<T> getInstance() {
            return (Factory<T>) FACTORY;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Model, Model> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.getInstance();
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }
}
