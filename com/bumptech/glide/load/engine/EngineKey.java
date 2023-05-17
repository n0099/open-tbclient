package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes8.dex */
public class EngineKey implements Key {
    public int hashCode;
    public final int height;
    public final Object model;
    public final Options options;
    public final Class<?> resourceClass;
    public final Key signature;
    public final Class<?> transcodeClass;
    public final Map<Class<?>, Transformation<?>> transformations;
    public final int width;

    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.model = Preconditions.checkNotNull(obj);
        this.signature = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.transformations = (Map) Preconditions.checkNotNull(map);
        this.resourceClass = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.model.equals(engineKey.model) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width || !this.transformations.equals(engineKey.transformations) || !this.resourceClass.equals(engineKey.resourceClass) || !this.transcodeClass.equals(engineKey.transcodeClass) || !this.options.equals(engineKey.options)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.model.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = (hashCode * 31) + this.signature.hashCode();
            this.hashCode = hashCode2;
            int i = (hashCode2 * 31) + this.width;
            this.hashCode = i;
            int i2 = (i * 31) + this.height;
            this.hashCode = i2;
            int hashCode3 = (i2 * 31) + this.transformations.hashCode();
            this.hashCode = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.resourceClass.hashCode();
            this.hashCode = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.transcodeClass.hashCode();
            this.hashCode = hashCode5;
            this.hashCode = (hashCode5 * 31) + this.options.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.resourceClass + ", transcodeClass=" + this.transcodeClass + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.transformations + ", options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
