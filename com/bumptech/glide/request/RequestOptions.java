package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;
/* loaded from: classes5.dex */
public class RequestOptions implements Cloneable {
    public static final int DISK_CACHE_STRATEGY = 4;
    public static final int ERROR_ID = 32;
    public static final int ERROR_PLACEHOLDER = 16;
    public static final int FALLBACK = 8192;
    public static final int FALLBACK_ID = 16384;
    public static final int IS_CACHEABLE = 256;
    public static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    public static final int OVERRIDE = 512;
    public static final int PLACEHOLDER = 64;
    public static final int PLACEHOLDER_ID = 128;
    public static final int PRIORITY = 8;
    public static final int RESOURCE_CLASS = 4096;
    public static final int SIGNATURE = 1024;
    public static final int SIZE_MULTIPLIER = 2;
    public static final int THEME = 32768;
    public static final int TRANSFORMATION = 2048;
    public static final int TRANSFORMATION_ALLOWED = 65536;
    public static final int TRANSFORMATION_REQUIRED = 131072;
    public static final int UNSET = -1;
    public static final int USE_ANIMATION_POOL = 1048576;
    public static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    @Nullable
    public static RequestOptions centerCropOptions;
    @Nullable
    public static RequestOptions centerInsideOptions;
    @Nullable
    public static RequestOptions circleCropOptions;
    @Nullable
    public static RequestOptions fitCenterOptions;
    @Nullable
    public static RequestOptions noAnimationOptions;
    @Nullable
    public static RequestOptions noTransformOptions;
    @Nullable
    public static RequestOptions skipMemoryCacheFalseOptions;
    @Nullable
    public static RequestOptions skipMemoryCacheTrueOptions;
    public int errorId;
    @Nullable
    public Drawable errorPlaceholder;
    @Nullable
    public Drawable fallbackDrawable;
    public int fallbackId;
    public int fields;
    public boolean isAutoCloneEnabled;
    public boolean isLocked;
    public boolean isTransformationRequired;
    public boolean onlyRetrieveFromCache;
    @Nullable
    public Drawable placeholderDrawable;
    public int placeholderId;
    @Nullable
    public Resources.Theme theme;
    public boolean useAnimationPool;
    public boolean useUnlimitedSourceGeneratorsPool;
    public float sizeMultiplier = 1.0f;
    @NonNull
    public DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    @NonNull
    public Priority priority = Priority.NORMAL;
    public boolean isCacheable = true;
    public int overrideHeight = -1;
    public int overrideWidth = -1;
    @NonNull
    public Key signature = EmptySignature.obtain();
    public boolean isTransformationAllowed = true;
    @NonNull
    public Options options = new Options();
    @NonNull
    public Map<Class<?>, Transformation<?>> transformations = new CachedHashCodeArrayMap();
    @NonNull
    public Class<?> resourceClass = Object.class;
    public boolean isScaleOnlyOrNoTransform = true;

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i2) {
        return new RequestOptions().encodeQuality(i2);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return new RequestOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long j) {
        return new RequestOptions().frame(j);
    }

    private boolean isSet(int i2) {
        return isSet(this.fields, i2);
    }

    public static boolean isSet(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t) {
        return new RequestOptions().set(option, t);
    }

    @NonNull
    private RequestOptions optionalScaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, false);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        return new RequestOptions().override(i2, i3);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        return new RequestOptions().priority(priority);
    }

    @NonNull
    private RequestOptions scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, true);
    }

    @NonNull
    private RequestOptions selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        }
        return this;
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key key) {
        return new RequestOptions().signature(key);
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return new RequestOptions().sizeMultiplier(f2);
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i2) {
        return new RequestOptions().timeout(i2);
    }

    @NonNull
    @CheckResult
    public RequestOptions apply(@NonNull RequestOptions requestOptions) {
        if (this.isAutoCloneEnabled) {
            return m34clone().apply(requestOptions);
        }
        if (isSet(requestOptions.fields, 2)) {
            this.sizeMultiplier = requestOptions.sizeMultiplier;
        }
        if (isSet(requestOptions.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = requestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(requestOptions.fields, 1048576)) {
            this.useAnimationPool = requestOptions.useAnimationPool;
        }
        if (isSet(requestOptions.fields, 4)) {
            this.diskCacheStrategy = requestOptions.diskCacheStrategy;
        }
        if (isSet(requestOptions.fields, 8)) {
            this.priority = requestOptions.priority;
        }
        if (isSet(requestOptions.fields, 16)) {
            this.errorPlaceholder = requestOptions.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(requestOptions.fields, 32)) {
            this.errorId = requestOptions.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(requestOptions.fields, 64)) {
            this.placeholderDrawable = requestOptions.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(requestOptions.fields, 128)) {
            this.placeholderId = requestOptions.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(requestOptions.fields, 256)) {
            this.isCacheable = requestOptions.isCacheable;
        }
        if (isSet(requestOptions.fields, 512)) {
            this.overrideWidth = requestOptions.overrideWidth;
            this.overrideHeight = requestOptions.overrideHeight;
        }
        if (isSet(requestOptions.fields, 1024)) {
            this.signature = requestOptions.signature;
        }
        if (isSet(requestOptions.fields, 4096)) {
            this.resourceClass = requestOptions.resourceClass;
        }
        if (isSet(requestOptions.fields, 8192)) {
            this.fallbackDrawable = requestOptions.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(requestOptions.fields, 16384)) {
            this.fallbackId = requestOptions.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(requestOptions.fields, 32768)) {
            this.theme = requestOptions.theme;
        }
        if (isSet(requestOptions.fields, 65536)) {
            this.isTransformationAllowed = requestOptions.isTransformationAllowed;
        }
        if (isSet(requestOptions.fields, 131072)) {
            this.isTransformationRequired = requestOptions.isTransformationRequired;
        }
        if (isSet(requestOptions.fields, 2048)) {
            this.transformations.putAll(requestOptions.transformations);
            this.isScaleOnlyOrNoTransform = requestOptions.isScaleOnlyOrNoTransform;
        }
        if (isSet(requestOptions.fields, 524288)) {
            this.onlyRetrieveFromCache = requestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i2 = this.fields & (-2049);
            this.fields = i2;
            this.isTransformationRequired = false;
            this.fields = i2 & (-131073);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= requestOptions.fields;
        this.options.putAll(requestOptions.options);
        return selfOrThrowIfLocked();
    }

    @NonNull
    public RequestOptions autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return lock();
    }

    @NonNull
    @CheckResult
    public RequestOptions centerCrop() {
        return transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public RequestOptions centerInside() {
        return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @NonNull
    @CheckResult
    public RequestOptions circleCrop() {
        return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public RequestOptions decode(@NonNull Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return m34clone().decode(cls);
        }
        this.resourceClass = (Class) Preconditions.checkNotNull(cls);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public RequestOptions diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.isAutoCloneEnabled) {
            return m34clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public RequestOptions dontTransform() {
        if (this.isAutoCloneEnabled) {
            return m34clone().dontTransform();
        }
        this.transformations.clear();
        int i2 = this.fields & (-2049);
        this.fields = i2;
        this.isTransformationRequired = false;
        int i3 = i2 & (-131073);
        this.fields = i3;
        this.isTransformationAllowed = false;
        this.fields = i3 | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    public RequestOptions encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    @NonNull
    @CheckResult
    public RequestOptions encodeQuality(@IntRange(from = 0, to = 100) int i2) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof RequestOptions) {
            RequestOptions requestOptions = (RequestOptions) obj;
            return Float.compare(requestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == requestOptions.errorId && Util.bothNullOrEqual(this.errorPlaceholder, requestOptions.errorPlaceholder) && this.placeholderId == requestOptions.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, requestOptions.placeholderDrawable) && this.fallbackId == requestOptions.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, requestOptions.fallbackDrawable) && this.isCacheable == requestOptions.isCacheable && this.overrideHeight == requestOptions.overrideHeight && this.overrideWidth == requestOptions.overrideWidth && this.isTransformationRequired == requestOptions.isTransformationRequired && this.isTransformationAllowed == requestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == requestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == requestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(requestOptions.diskCacheStrategy) && this.priority == requestOptions.priority && this.options.equals(requestOptions.options) && this.transformations.equals(requestOptions.transformations) && this.resourceClass.equals(requestOptions.resourceClass) && Util.bothNullOrEqual(this.signature, requestOptions.signature) && Util.bothNullOrEqual(this.theme, requestOptions.theme);
        }
        return false;
    }

    @NonNull
    @CheckResult
    public RequestOptions error(@Nullable Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return m34clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i2 = this.fields | 16;
        this.fields = i2;
        this.errorId = 0;
        this.fields = i2 & (-33);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions fallback(@Nullable Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return m34clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i2 = this.fields | 8192;
        this.fields = i2;
        this.fallbackId = 0;
        this.fields = i2 & (-16385);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions fitCenter() {
        return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @NonNull
    @CheckResult
    public RequestOptions format(@NonNull DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    @NonNull
    @CheckResult
    public RequestOptions frame(@IntRange(from = 0) long j) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    @NonNull
    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    @NonNull
    public final Priority getPriority() {
        return this.priority;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    @NonNull
    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.theme;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    public boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    @NonNull
    public RequestOptions lock() {
        this.isLocked = true;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestOptions onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return m34clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalCenterCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalCenterInside() {
        return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalCircleCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalFitCenter() {
        return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @NonNull
    public final RequestOptions optionalTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return m34clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    @NonNull
    @CheckResult
    public RequestOptions override(int i2, int i3) {
        if (this.isAutoCloneEnabled) {
            return m34clone().override(i2, i3);
        }
        this.overrideWidth = i2;
        this.overrideHeight = i3;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions placeholder(@Nullable Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return m34clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i2 = this.fields | 64;
        this.fields = i2;
        this.placeholderId = 0;
        this.fields = i2 & (-129);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions priority(@NonNull Priority priority) {
        if (this.isAutoCloneEnabled) {
            return m34clone().priority(priority);
        }
        this.priority = (Priority) Preconditions.checkNotNull(priority);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public <T> RequestOptions set(@NonNull Option<T> option, @NonNull T t) {
        if (this.isAutoCloneEnabled) {
            return m34clone().set(option, t);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(t);
        this.options.set(option, t);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions signature(@NonNull Key key) {
        if (this.isAutoCloneEnabled) {
            return m34clone().signature(key);
        }
        this.signature = (Key) Preconditions.checkNotNull(key);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.isAutoCloneEnabled) {
            return m34clone().sizeMultiplier(f2);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.sizeMultiplier = f2;
            this.fields |= 2;
            return selfOrThrowIfLocked();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public RequestOptions skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return m34clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions theme(@Nullable Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return m34clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions timeout(@IntRange(from = 0) int i2) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    public final RequestOptions transform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return m34clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    @NonNull
    @CheckResult
    public RequestOptions transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    @NonNull
    @CheckResult
    public RequestOptions useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return m34clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return m34clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int i2) {
        return new RequestOptions().error(i2);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int i2) {
        return overrideOf(i2, i2);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int i2) {
        return new RequestOptions().placeholder(i2);
    }

    @NonNull
    private RequestOptions scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z) {
        RequestOptions transform = z ? transform(downsampleStrategy, transformation) : optionalTransform(downsampleStrategy, transformation);
        transform.isScaleOnlyOrNoTransform = true;
        return transform;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @CheckResult
    /* renamed from: clone */
    public RequestOptions m34clone() {
        try {
            RequestOptions requestOptions = (RequestOptions) super.clone();
            Options options = new Options();
            requestOptions.options = options;
            options.putAll(this.options);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            requestOptions.transformations = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.transformations);
            requestOptions.isLocked = false;
            requestOptions.isAutoCloneEnabled = false;
            return requestOptions;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    @NonNull
    @CheckResult
    public RequestOptions transform(@NonNull Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    @NonNull
    private RequestOptions transform(@NonNull Transformation<Bitmap> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return m34clone().transform(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        transform(Bitmap.class, transformation, z);
        transform(Drawable.class, drawableTransformation, z);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public <T> RequestOptions optionalTransform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        return transform(cls, transformation, false);
    }

    @NonNull
    @CheckResult
    public RequestOptions override(int i2) {
        return override(i2, i2);
    }

    @NonNull
    @CheckResult
    public RequestOptions error(@DrawableRes int i2) {
        if (this.isAutoCloneEnabled) {
            return m34clone().error(i2);
        }
        this.errorId = i2;
        int i3 = this.fields | 32;
        this.fields = i3;
        this.errorPlaceholder = null;
        this.fields = i3 & (-17);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions fallback(@DrawableRes int i2) {
        if (this.isAutoCloneEnabled) {
            return m34clone().fallback(i2);
        }
        this.fallbackId = i2;
        int i3 = this.fields | 16384;
        this.fields = i3;
        this.fallbackDrawable = null;
        this.fields = i3 & (-8193);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public RequestOptions placeholder(@DrawableRes int i2) {
        if (this.isAutoCloneEnabled) {
            return m34clone().placeholder(i2);
        }
        this.placeholderId = i2;
        int i3 = this.fields | 128;
        this.fields = i3;
        this.placeholderDrawable = null;
        this.fields = i3 & (-65);
        return selfOrThrowIfLocked();
    }

    @NonNull
    private <T> RequestOptions transform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return m34clone().transform(cls, transformation, z);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(cls, transformation);
        int i2 = this.fields | 2048;
        this.fields = i2;
        this.isTransformationAllowed = true;
        int i3 = i2 | 65536;
        this.fields = i3;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields = i3 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public <T> RequestOptions transform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        return transform(cls, transformation, true);
    }
}
