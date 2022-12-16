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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public DiskCacheStrategy diskCacheStrategy;
    public int errorId;
    @Nullable
    public Drawable errorPlaceholder;
    @Nullable
    public Drawable fallbackDrawable;
    public int fallbackId;
    public int fields;
    public boolean isAutoCloneEnabled;
    public boolean isCacheable;
    public boolean isLocked;
    public boolean isScaleOnlyOrNoTransform;
    public boolean isTransformationAllowed;
    public boolean isTransformationRequired;
    public boolean onlyRetrieveFromCache;
    @NonNull
    public Options options;
    public int overrideHeight;
    public int overrideWidth;
    @Nullable
    public Drawable placeholderDrawable;
    public int placeholderId;
    @NonNull
    public Priority priority;
    @NonNull
    public Class<?> resourceClass;
    @NonNull
    public Key signature;
    public float sizeMultiplier;
    @Nullable
    public Resources.Theme theme;
    @NonNull
    public Map<Class<?>, Transformation<?>> transformations;
    public boolean useAnimationPool;
    public boolean useUnlimitedSourceGeneratorsPool;

    public static boolean isSet(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? (i & i2) != 0 : invokeII.booleanValue;
    }

    private T self() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this : (T) invokeV.objValue;
    }

    public BaseRequestOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sizeMultiplier = 1.0f;
        this.diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        this.priority = Priority.NORMAL;
        this.isCacheable = true;
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.signature = EmptySignature.obtain();
        this.isTransformationAllowed = true;
        this.options = new Options();
        this.transformations = new CachedHashCodeArrayMap();
        this.resourceClass = Object.class;
        this.isScaleOnlyOrNoTransform = true;
    }

    private boolean isSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            return isSet(this.fields, i);
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<com.bumptech.glide.load.resource.bitmap.DownsampleStrategy>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downsampleStrategy)) == null) {
            return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, compressFormat)) == null) {
            return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<java.lang.Integer>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T encodeQuality(@IntRange(from = 0, to = 100) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i));
        }
        return (T) invokeI.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<com.bumptech.glide.load.DecodeFormat>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T format(@NonNull DecodeFormat decodeFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, decodeFormat)) == null) {
            Preconditions.checkNotNull(decodeFormat);
            return (T) set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<java.lang.Long>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T frame(@IntRange(from = 0) long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j)) == null) {
            return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
        }
        return (T) invokeJ.objValue;
    }

    @NonNull
    @CheckResult
    public T onlyRetrieveFromCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048631, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().onlyRetrieveFromCache(z);
            }
            this.onlyRetrieveFromCache = z;
            this.fields |= 524288;
            return selfOrThrowIfLocked();
        }
        return (T) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public T optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, transformation)) == null) {
            return transform(transformation, false);
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T override(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) {
            return override(i, i);
        }
        return (T) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public T skipMemoryCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048648, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().skipMemoryCache(true);
            }
            this.isCacheable = !z;
            this.fields |= 256;
            return selfOrThrowIfLocked();
        }
        return (T) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public T theme(@Nullable Resources.Theme theme) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, theme)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().theme(theme);
            }
            this.theme = theme;
            this.fields |= 32768;
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<java.lang.Integer>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T timeout(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i)) == null) {
            return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i));
        }
        return (T) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, transformation)) == null) {
            return transform(transformation, true);
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, transformationArr)) == null) {
            return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T useAnimationPool(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048658, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().useAnimationPool(z);
            }
            this.useAnimationPool = z;
            this.fields |= 1048576;
            return selfOrThrowIfLocked();
        }
        return (T) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048659, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().useUnlimitedSourceGeneratorsPool(z);
            }
            this.useUnlimitedSourceGeneratorsPool = z;
            this.fields |= 262144;
            return selfOrThrowIfLocked();
        }
        return (T) invokeZ.objValue;
    }

    @NonNull
    private T optionalScaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, downsampleStrategy, transformation)) == null) {
            return scaleOnlyTransform(downsampleStrategy, transformation, false);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    private T scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, downsampleStrategy, transformation)) == null) {
            return scaleOnlyTransform(downsampleStrategy, transformation, true);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    public final T optionalTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, downsampleStrategy, transformation)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().optionalTransform(downsampleStrategy, transformation);
            }
            downsample(downsampleStrategy);
            return transform(transformation, false);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public T override(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048640, this, i, i2)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().override(i, i2);
            }
            this.overrideWidth = i;
            this.overrideHeight = i2;
            this.fields |= 512;
            return selfOrThrowIfLocked();
        }
        return (T) invokeII.objValue;
    }

    @NonNull
    @CheckResult
    public <Y> T set(@NonNull Option<Y> option, @NonNull Y y) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, option, y)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().set(option, y);
            }
            Preconditions.checkNotNull(option);
            Preconditions.checkNotNull(y);
            this.options.set(option, y);
            return selfOrThrowIfLocked();
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public final T transform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, downsampleStrategy, transformation)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().transform(downsampleStrategy, transformation);
            }
            downsample(downsampleStrategy);
            return transform(transformation);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    private T scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z) {
        InterceptResult invokeLLZ;
        T optionalTransform;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, this, downsampleStrategy, transformation, z)) == null) {
            if (z) {
                optionalTransform = transform(downsampleStrategy, transformation);
            } else {
                optionalTransform = optionalTransform(downsampleStrategy, transformation);
            }
            optionalTransform.isScaleOnlyOrNoTransform = true;
            return optionalTransform;
        }
        return (T) invokeLLZ.objValue;
    }

    @NonNull
    @CheckResult
    public T apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, baseRequestOptions)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().apply(baseRequestOptions);
            }
            if (isSet(baseRequestOptions.fields, 2)) {
                this.sizeMultiplier = baseRequestOptions.sizeMultiplier;
            }
            if (isSet(baseRequestOptions.fields, 262144)) {
                this.useUnlimitedSourceGeneratorsPool = baseRequestOptions.useUnlimitedSourceGeneratorsPool;
            }
            if (isSet(baseRequestOptions.fields, 1048576)) {
                this.useAnimationPool = baseRequestOptions.useAnimationPool;
            }
            if (isSet(baseRequestOptions.fields, 4)) {
                this.diskCacheStrategy = baseRequestOptions.diskCacheStrategy;
            }
            if (isSet(baseRequestOptions.fields, 8)) {
                this.priority = baseRequestOptions.priority;
            }
            if (isSet(baseRequestOptions.fields, 16)) {
                this.errorPlaceholder = baseRequestOptions.errorPlaceholder;
                this.errorId = 0;
                this.fields &= -33;
            }
            if (isSet(baseRequestOptions.fields, 32)) {
                this.errorId = baseRequestOptions.errorId;
                this.errorPlaceholder = null;
                this.fields &= -17;
            }
            if (isSet(baseRequestOptions.fields, 64)) {
                this.placeholderDrawable = baseRequestOptions.placeholderDrawable;
                this.placeholderId = 0;
                this.fields &= -129;
            }
            if (isSet(baseRequestOptions.fields, 128)) {
                this.placeholderId = baseRequestOptions.placeholderId;
                this.placeholderDrawable = null;
                this.fields &= -65;
            }
            if (isSet(baseRequestOptions.fields, 256)) {
                this.isCacheable = baseRequestOptions.isCacheable;
            }
            if (isSet(baseRequestOptions.fields, 512)) {
                this.overrideWidth = baseRequestOptions.overrideWidth;
                this.overrideHeight = baseRequestOptions.overrideHeight;
            }
            if (isSet(baseRequestOptions.fields, 1024)) {
                this.signature = baseRequestOptions.signature;
            }
            if (isSet(baseRequestOptions.fields, 4096)) {
                this.resourceClass = baseRequestOptions.resourceClass;
            }
            if (isSet(baseRequestOptions.fields, 8192)) {
                this.fallbackDrawable = baseRequestOptions.fallbackDrawable;
                this.fallbackId = 0;
                this.fields &= -16385;
            }
            if (isSet(baseRequestOptions.fields, 16384)) {
                this.fallbackId = baseRequestOptions.fallbackId;
                this.fallbackDrawable = null;
                this.fields &= -8193;
            }
            if (isSet(baseRequestOptions.fields, 32768)) {
                this.theme = baseRequestOptions.theme;
            }
            if (isSet(baseRequestOptions.fields, 65536)) {
                this.isTransformationAllowed = baseRequestOptions.isTransformationAllowed;
            }
            if (isSet(baseRequestOptions.fields, 131072)) {
                this.isTransformationRequired = baseRequestOptions.isTransformationRequired;
            }
            if (isSet(baseRequestOptions.fields, 2048)) {
                this.transformations.putAll(baseRequestOptions.transformations);
                this.isScaleOnlyOrNoTransform = baseRequestOptions.isScaleOnlyOrNoTransform;
            }
            if (isSet(baseRequestOptions.fields, 524288)) {
                this.onlyRetrieveFromCache = baseRequestOptions.onlyRetrieveFromCache;
            }
            if (!this.isTransformationAllowed) {
                this.transformations.clear();
                int i = this.fields & (-2049);
                this.fields = i;
                this.isTransformationRequired = false;
                this.fields = i & (-131073);
                this.isScaleOnlyOrNoTransform = true;
            }
            this.fields |= baseRequestOptions.fields;
            this.options.putAll(baseRequestOptions.options);
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public T autoClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.isLocked && !this.isAutoCloneEnabled) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            this.isAutoCloneEnabled = true;
            return lock();
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T centerCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T centerInside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T circleCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<java.lang.Boolean>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T disallowHardwareConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.bumptech.glide.load.Option<java.lang.Boolean>, com.bumptech.glide.load.Option<Y> */
    @NonNull
    @CheckResult
    public T dontAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T fitCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.diskCacheStrategy;
        }
        return (DiskCacheStrategy) invokeV.objValue;
    }

    public final int getErrorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.errorId;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.errorPlaceholder;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.fallbackDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public final int getFallbackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.fallbackId;
        }
        return invokeV.intValue;
    }

    public final boolean getOnlyRetrieveFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.onlyRetrieveFromCache;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final Options getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.options;
        }
        return (Options) invokeV.objValue;
    }

    public final int getOverrideHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.overrideHeight;
        }
        return invokeV.intValue;
    }

    public final int getOverrideWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.overrideWidth;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.placeholderDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public final int getPlaceholderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.placeholderId;
        }
        return invokeV.intValue;
    }

    @NonNull
    public final Priority getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.priority;
        }
        return (Priority) invokeV.objValue;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.resourceClass;
        }
        return (Class) invokeV.objValue;
    }

    @NonNull
    public final Key getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.signature;
        }
        return (Key) invokeV.objValue;
    }

    public final float getSizeMultiplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.sizeMultiplier;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.theme;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.transformations;
        }
        return (Map) invokeV.objValue;
    }

    public final boolean getUseAnimationPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.useAnimationPool;
        }
        return invokeV.booleanValue;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.useUnlimitedSourceGeneratorsPool;
        }
        return invokeV.booleanValue;
    }

    public final boolean isAutoCloneEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.isAutoCloneEnabled;
        }
        return invokeV.booleanValue;
    }

    public final boolean isDiskCacheStrategySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return isSet(4);
        }
        return invokeV.booleanValue;
    }

    public final boolean isLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.isLocked;
        }
        return invokeV.booleanValue;
    }

    public final boolean isMemoryCacheable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.isCacheable;
        }
        return invokeV.booleanValue;
    }

    public final boolean isPrioritySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return isSet(8);
        }
        return invokeV.booleanValue;
    }

    public boolean isScaleOnlyOrNoTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.isScaleOnlyOrNoTransform;
        }
        return invokeV.booleanValue;
    }

    public final boolean isSkipMemoryCacheSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return isSet(256);
        }
        return invokeV.booleanValue;
    }

    public final boolean isTransformationAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.isTransformationAllowed;
        }
        return invokeV.booleanValue;
    }

    public final boolean isTransformationRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.isTransformationRequired;
        }
        return invokeV.booleanValue;
    }

    public final boolean isTransformationSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return isSet(2048);
        }
        return invokeV.booleanValue;
    }

    public final boolean isValidOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public T lock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            this.isLocked = true;
            return self();
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T optionalCenterCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T optionalCenterInside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T optionalCircleCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T optionalFitCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    public final T selfOrThrowIfLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (!this.isLocked) {
                return self();
            }
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @CheckResult
    /* renamed from: clone */
    public T m76clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                T t = (T) super.clone();
                Options options = new Options();
                t.options = options;
                options.putAll(this.options);
                CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
                t.transformations = cachedHashCodeArrayMap;
                cachedHashCodeArrayMap.putAll(this.transformations);
                t.isLocked = false;
                t.isAutoCloneEnabled = false;
                return t;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T dontTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().dontTransform();
            }
            this.transformations.clear();
            int i = this.fields & (-2049);
            this.fields = i;
            this.isTransformationRequired = false;
            int i2 = i & (-131073);
            this.fields = i2;
            this.isTransformationAllowed = false;
            this.fields = i2 | 65536;
            this.isScaleOnlyOrNoTransform = true;
            return selfOrThrowIfLocked();
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public T decode(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().decode(cls);
            }
            this.resourceClass = (Class) Preconditions.checkNotNull(cls);
            this.fields |= 4096;
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, diskCacheStrategy)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().diskCacheStrategy(diskCacheStrategy);
            }
            this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
            this.fields |= 4;
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T error(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().error(i);
            }
            this.errorId = i;
            int i2 = this.fields | 32;
            this.fields = i2;
            this.errorPlaceholder = null;
            this.fields = i2 & (-17);
            return selfOrThrowIfLocked();
        }
        return (T) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public T fallback(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().fallback(i);
            }
            this.fallbackId = i;
            int i2 = this.fields | 16384;
            this.fields = i2;
            this.fallbackDrawable = null;
            this.fields = i2 & (-8193);
            return selfOrThrowIfLocked();
        }
        return (T) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public T placeholder(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().placeholder(i);
            }
            this.placeholderId = i;
            int i2 = this.fields | 128;
            this.fields = i2;
            this.placeholderDrawable = null;
            this.fields = i2 & (-65);
            return selfOrThrowIfLocked();
        }
        return (T) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public T priority(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, priority)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().priority(priority);
            }
            this.priority = (Priority) Preconditions.checkNotNull(priority);
            this.fields |= 8;
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T signature(@NonNull Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, key)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().signature(key);
            }
            this.signature = (Key) Preconditions.checkNotNull(key);
            this.fields |= 1024;
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048647, this, f)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().sizeMultiplier(f);
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.sizeMultiplier = f;
                this.fields |= 2;
                return selfOrThrowIfLocked();
            }
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        return (T) invokeF.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (!(obj instanceof BaseRequestOptions)) {
                return false;
            }
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
            if (Float.compare(baseRequestOptions.sizeMultiplier, this.sizeMultiplier) != 0 || this.errorId != baseRequestOptions.errorId || !Util.bothNullOrEqual(this.errorPlaceholder, baseRequestOptions.errorPlaceholder) || this.placeholderId != baseRequestOptions.placeholderId || !Util.bothNullOrEqual(this.placeholderDrawable, baseRequestOptions.placeholderDrawable) || this.fallbackId != baseRequestOptions.fallbackId || !Util.bothNullOrEqual(this.fallbackDrawable, baseRequestOptions.fallbackDrawable) || this.isCacheable != baseRequestOptions.isCacheable || this.overrideHeight != baseRequestOptions.overrideHeight || this.overrideWidth != baseRequestOptions.overrideWidth || this.isTransformationRequired != baseRequestOptions.isTransformationRequired || this.isTransformationAllowed != baseRequestOptions.isTransformationAllowed || this.useUnlimitedSourceGeneratorsPool != baseRequestOptions.useUnlimitedSourceGeneratorsPool || this.onlyRetrieveFromCache != baseRequestOptions.onlyRetrieveFromCache || !this.diskCacheStrategy.equals(baseRequestOptions.diskCacheStrategy) || this.priority != baseRequestOptions.priority || !this.options.equals(baseRequestOptions.options) || !this.transformations.equals(baseRequestOptions.transformations) || !this.resourceClass.equals(baseRequestOptions.resourceClass) || !Util.bothNullOrEqual(this.signature, baseRequestOptions.signature) || !Util.bothNullOrEqual(this.theme, baseRequestOptions.theme)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    @CheckResult
    public T error(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().error(drawable);
            }
            this.errorPlaceholder = drawable;
            int i = this.fields | 16;
            this.fields = i;
            this.errorId = 0;
            this.fields = i & (-33);
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T fallback(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, drawable)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().fallback(drawable);
            }
            this.fallbackDrawable = drawable;
            int i = this.fields | 8192;
            this.fields = i;
            this.fallbackId = 0;
            this.fields = i & (-16385);
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public T placeholder(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, drawable)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().placeholder(drawable);
            }
            this.placeholderDrawable = drawable;
            int i = this.fields | 64;
            this.fields = i;
            this.placeholderId = 0;
            this.fields = i & (-129);
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
        }
        return invokeV.intValue;
    }

    @NonNull
    @CheckResult
    public <Y> T optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048638, this, cls, transformation)) == null) {
            return transform(cls, transformation, false);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public <Y> T transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048654, this, cls, transformation)) == null) {
            return transform(cls, transformation, true);
        }
        return (T) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bumptech.glide.load.Transformation<android.graphics.Bitmap> */
    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.bumptech.glide.load.Transformation<android.graphics.drawable.BitmapDrawable>, com.bumptech.glide.load.Transformation<Y> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T transform(@NonNull Transformation<Bitmap> transformation, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048652, this, transformation, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().transform(transformation, z);
            }
            DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
            transform(Bitmap.class, transformation, z);
            transform(Drawable.class, drawableTransformation, z);
            transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
            transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
            return selfOrThrowIfLocked();
        }
        return (T) invokeLZ.objValue;
    }

    @NonNull
    public <Y> T transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048655, this, cls, transformation, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return (T) m76clone().transform(cls, transformation, z);
            }
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(transformation);
            this.transformations.put(cls, transformation);
            int i = this.fields | 2048;
            this.fields = i;
            this.isTransformationAllowed = true;
            int i2 = i | 65536;
            this.fields = i2;
            this.isScaleOnlyOrNoTransform = false;
            if (z) {
                this.fields = i2 | 131072;
                this.isTransformationRequired = true;
            }
            return selfOrThrowIfLocked();
        }
        return (T) invokeLLZ.objValue;
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap>... transformationArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, transformationArr)) == null) {
            if (transformationArr.length > 1) {
                return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
            }
            if (transformationArr.length == 1) {
                return transform(transformationArr[0]);
            }
            return selfOrThrowIfLocked();
        }
        return (T) invokeL.objValue;
    }
}
