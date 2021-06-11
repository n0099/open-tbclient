package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    public static final String TAG = "ResourceLoader";
    public final Resources resources;
    public final ModelLoader<Uri, Data> uriLoader;

    /* loaded from: classes6.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        public final Resources resources;

        public AssetFileDescriptorFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes6.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        public final Resources resources;

        public FileDescriptorFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes6.dex */
    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
        public final Resources resources;

        public StreamFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    /* loaded from: classes6.dex */
    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
        public final Resources resources;

        public UriFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, UnitModelLoader.getInstance());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Nullable
    private Uri getResourceUri(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + this.resources.getResourceTypeName(num.intValue()) + '/' + this.resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Received invalid resource id: " + num, e2);
                return null;
            }
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Integer num) {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Integer num, int i2, int i3, @NonNull Options options) {
        Uri resourceUri = getResourceUri(num);
        if (resourceUri == null) {
            return null;
        }
        return this.uriLoader.buildLoadData(resourceUri, i2, i3, options);
    }
}
