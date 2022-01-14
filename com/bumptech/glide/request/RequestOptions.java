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
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;
/* loaded from: classes2.dex */
public class RequestOptions implements Cloneable {
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

    public RequestOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transformation)) == null) ? new RequestOptions().transform(transformation) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerCropTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (centerCropOptions == null) {
                centerCropOptions = new RequestOptions().centerCrop().autoClone();
            }
            return centerCropOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerInsideTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (centerInsideOptions == null) {
                centerInsideOptions = new RequestOptions().centerInside().autoClone();
            }
            return centerInsideOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions circleCropTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (circleCropOptions == null) {
                circleCropOptions = new RequestOptions().circleCrop().autoClone();
            }
            return circleCropOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) ? new RequestOptions().decode(cls) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, diskCacheStrategy)) == null) ? new RequestOptions().diskCacheStrategy(diskCacheStrategy) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downsampleStrategy)) == null) ? new RequestOptions().downsample(downsampleStrategy) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, compressFormat)) == null) ? new RequestOptions().encodeFormat(compressFormat) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? new RequestOptions().encodeQuality(i2) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, drawable)) == null) ? new RequestOptions().error(drawable) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions fitCenterTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (fitCenterOptions == null) {
                fitCenterOptions = new RequestOptions().fitCenter().autoClone();
            }
            return fitCenterOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, decodeFormat)) == null) ? new RequestOptions().format(decodeFormat) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65550, null, j2)) == null) ? new RequestOptions().frame(j2) : (RequestOptions) invokeJ.objValue;
    }

    private boolean isSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i2)) == null) ? isSet(this.fields, i2) : invokeI.booleanValue;
    }

    public static boolean isSet(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65552, null, i2, i3)) == null) ? (i2 & i3) != 0 : invokeII.booleanValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (noAnimationOptions == null) {
                noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
            }
            return noAnimationOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (noTransformOptions == null) {
                noTransformOptions = new RequestOptions().dontTransform().autoClone();
            }
            return noTransformOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, option, t)) == null) ? new RequestOptions().set(option, t) : (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    private RequestOptions optionalScaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, this, downsampleStrategy, transformation)) == null) ? scaleOnlyTransform(downsampleStrategy, transformation, false) : (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65558, null, i2, i3)) == null) ? new RequestOptions().override(i2, i3) : (RequestOptions) invokeII.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, drawable)) == null) ? new RequestOptions().placeholder(drawable) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, priority)) == null) ? new RequestOptions().priority(priority) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    private RequestOptions scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, this, downsampleStrategy, transformation)) == null) ? scaleOnlyTransform(downsampleStrategy, transformation, true) : (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    private RequestOptions selfOrThrowIfLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            if (this.isLocked) {
                throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
            }
            return this;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, key)) == null) ? new RequestOptions().signature(key) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65566, null, f2)) == null) ? new RequestOptions().sizeMultiplier(f2) : (RequestOptions) invokeF.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65567, null, z)) == null) {
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
        return (RequestOptions) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i2)) == null) ? new RequestOptions().timeout(i2) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions apply(@NonNull RequestOptions requestOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestOptions)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().apply(requestOptions);
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
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    public RequestOptions autoClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.isLocked && !this.isAutoCloneEnabled) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            this.isAutoCloneEnabled = true;
            return lock();
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions centerCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions centerInside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions circleCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions decode(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().decode(cls);
            }
            this.resourceClass = (Class) Preconditions.checkNotNull(cls);
            this.fields |= 4096;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions disallowHardwareConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, diskCacheStrategy)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().diskCacheStrategy(diskCacheStrategy);
            }
            this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
            this.fields |= 4;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions dontAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions dontTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().dontTransform();
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
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downsampleStrategy)) == null) ? set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy)) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, compressFormat)) == null) ? set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat)) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions encodeQuality(@IntRange(from = 0, to = 100) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i2)) : (RequestOptions) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj instanceof RequestOptions) {
                RequestOptions requestOptions = (RequestOptions) obj;
                return Float.compare(requestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == requestOptions.errorId && Util.bothNullOrEqual(this.errorPlaceholder, requestOptions.errorPlaceholder) && this.placeholderId == requestOptions.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, requestOptions.placeholderDrawable) && this.fallbackId == requestOptions.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, requestOptions.fallbackDrawable) && this.isCacheable == requestOptions.isCacheable && this.overrideHeight == requestOptions.overrideHeight && this.overrideWidth == requestOptions.overrideWidth && this.isTransformationRequired == requestOptions.isTransformationRequired && this.isTransformationAllowed == requestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == requestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == requestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(requestOptions.diskCacheStrategy) && this.priority == requestOptions.priority && this.options.equals(requestOptions.options) && this.transformations.equals(requestOptions.transformations) && this.resourceClass.equals(requestOptions.resourceClass) && Util.bothNullOrEqual(this.signature, requestOptions.signature) && Util.bothNullOrEqual(this.theme, requestOptions.theme);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions error(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().error(drawable);
            }
            this.errorPlaceholder = drawable;
            int i2 = this.fields | 16;
            this.fields = i2;
            this.errorId = 0;
            this.fields = i2 & (-33);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions fallback(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, drawable)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().fallback(drawable);
            }
            this.fallbackDrawable = drawable;
            int i2 = this.fields | 8192;
            this.fields = i2;
            this.fallbackId = 0;
            this.fields = i2 & (-16385);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions fitCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions format(@NonNull DecodeFormat decodeFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, decodeFormat)) == null) {
            Preconditions.checkNotNull(decodeFormat);
            return set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions frame(@IntRange(from = 0) long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) ? set(VideoDecoder.TARGET_FRAME, Long.valueOf(j2)) : (RequestOptions) invokeJ.objValue;
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.diskCacheStrategy : (DiskCacheStrategy) invokeV.objValue;
    }

    public final int getErrorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.errorId : invokeV.intValue;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.errorPlaceholder : (Drawable) invokeV.objValue;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.fallbackDrawable : (Drawable) invokeV.objValue;
    }

    public final int getFallbackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.fallbackId : invokeV.intValue;
    }

    public final boolean getOnlyRetrieveFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.onlyRetrieveFromCache : invokeV.booleanValue;
    }

    @NonNull
    public final Options getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.options : (Options) invokeV.objValue;
    }

    public final int getOverrideHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.overrideHeight : invokeV.intValue;
    }

    public final int getOverrideWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.overrideWidth : invokeV.intValue;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.placeholderDrawable : (Drawable) invokeV.objValue;
    }

    public final int getPlaceholderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.placeholderId : invokeV.intValue;
    }

    @NonNull
    public final Priority getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.priority : (Priority) invokeV.objValue;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.resourceClass : (Class) invokeV.objValue;
    }

    @NonNull
    public final Key getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.signature : (Key) invokeV.objValue;
    }

    public final float getSizeMultiplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.sizeMultiplier : invokeV.floatValue;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.theme : (Resources.Theme) invokeV.objValue;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.transformations : (Map) invokeV.objValue;
    }

    public final boolean getUseAnimationPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.useAnimationPool : invokeV.booleanValue;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.useUnlimitedSourceGeneratorsPool : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier))))))))))))))))))))) : invokeV.intValue;
    }

    public boolean isAutoCloneEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.isAutoCloneEnabled : invokeV.booleanValue;
    }

    public final boolean isDiskCacheStrategySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? isSet(4) : invokeV.booleanValue;
    }

    public final boolean isLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.isLocked : invokeV.booleanValue;
    }

    public final boolean isMemoryCacheable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.isCacheable : invokeV.booleanValue;
    }

    public final boolean isPrioritySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? isSet(8) : invokeV.booleanValue;
    }

    public boolean isScaleOnlyOrNoTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.isScaleOnlyOrNoTransform : invokeV.booleanValue;
    }

    public final boolean isSkipMemoryCacheSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? isSet(256) : invokeV.booleanValue;
    }

    public final boolean isTransformationAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.isTransformationAllowed : invokeV.booleanValue;
    }

    public final boolean isTransformationRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.isTransformationRequired : invokeV.booleanValue;
    }

    public final boolean isTransformationSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? isSet(2048) : invokeV.booleanValue;
    }

    public final boolean isValidOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? Util.isValidDimensions(this.overrideWidth, this.overrideHeight) : invokeV.booleanValue;
    }

    @NonNull
    public RequestOptions lock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            this.isLocked = true;
            return this;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions onlyRetrieveFromCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048631, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().onlyRetrieveFromCache(z);
            }
            this.onlyRetrieveFromCache = z;
            this.fields |= 524288;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalCenterCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalCenterInside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalCircleCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalFitCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter()) : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    public final RequestOptions optionalTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, downsampleStrategy, transformation)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().optionalTransform(downsampleStrategy, transformation);
            }
            downsample(downsampleStrategy);
            return transform(transformation, false);
        }
        return (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions override(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048640, this, i2, i3)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().override(i2, i3);
            }
            this.overrideWidth = i2;
            this.overrideHeight = i3;
            this.fields |= 512;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeII.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions placeholder(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, drawable)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().placeholder(drawable);
            }
            this.placeholderDrawable = drawable;
            int i2 = this.fields | 64;
            this.fields = i2;
            this.placeholderId = 0;
            this.fields = i2 & (-129);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions priority(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, priority)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().priority(priority);
            }
            this.priority = (Priority) Preconditions.checkNotNull(priority);
            this.fields |= 8;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <T> RequestOptions set(@NonNull Option<T> option, @NonNull T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, option, t)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().set(option, t);
            }
            Preconditions.checkNotNull(option);
            Preconditions.checkNotNull(t);
            this.options.set(option, t);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions signature(@NonNull Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, key)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().signature(key);
            }
            this.signature = (Key) Preconditions.checkNotNull(key);
            this.fields |= 1024;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048646, this, f2)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().sizeMultiplier(f2);
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.sizeMultiplier = f2;
                this.fields |= 2;
                return selfOrThrowIfLocked();
            }
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        return (RequestOptions) invokeF.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions skipMemoryCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048647, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().skipMemoryCache(true);
            }
            this.isCacheable = !z;
            this.fields |= 256;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions theme(@Nullable Resources.Theme theme) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, theme)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().theme(theme);
            }
            this.theme = theme;
            this.fields |= 32768;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions timeout(@IntRange(from = 0) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i2)) == null) ? set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i2)) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public final RequestOptions transform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048651, this, downsampleStrategy, transformation)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().transform(downsampleStrategy, transformation);
            }
            downsample(downsampleStrategy);
            return transform(transformation);
        }
        return (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, transformationArr)) == null) ? transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions useAnimationPool(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048654, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().useAnimationPool(z);
            }
            this.useAnimationPool = z;
            this.fields |= 1048576;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048655, this, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().useUnlimitedSourceGeneratorsPool(z);
            }
            this.useUnlimitedSourceGeneratorsPool = z;
            this.fields |= 262144;
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeZ.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? new RequestOptions().error(i2) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) ? overrideOf(i2, i2) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i2)) == null) ? new RequestOptions().placeholder(i2) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    private RequestOptions scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65563, this, downsampleStrategy, transformation, z)) == null) {
            RequestOptions transform = z ? transform(downsampleStrategy, transformation) : optionalTransform(downsampleStrategy, transformation);
            transform.isScaleOnlyOrNoTransform = true;
            return transform;
        }
        return (RequestOptions) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @CheckResult
    /* renamed from: clone */
    public RequestOptions m111clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, transformation)) == null) ? transform(transformation, false) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions transform(@NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, transformation)) == null) ? transform(transformation, true) : (RequestOptions) invokeL.objValue;
    }

    @NonNull
    private RequestOptions transform(@NonNull Transformation<Bitmap> transformation, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65569, this, transformation, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().transform(transformation, z);
            }
            DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
            transform(Bitmap.class, transformation, z);
            transform(Drawable.class, drawableTransformation, z);
            transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
            transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeLZ.objValue;
    }

    @NonNull
    @CheckResult
    public <T> RequestOptions optionalTransform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048638, this, cls, transformation)) == null) ? transform(cls, transformation, false) : (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions override(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) ? override(i2, i2) : (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions error(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().error(i2);
            }
            this.errorId = i2;
            int i3 = this.fields | 32;
            this.fields = i3;
            this.errorPlaceholder = null;
            this.fields = i3 & (-17);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions fallback(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().fallback(i2);
            }
            this.fallbackId = i2;
            int i3 = this.fields | 16384;
            this.fields = i3;
            this.fallbackDrawable = null;
            this.fields = i3 & (-8193);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public RequestOptions placeholder(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().placeholder(i2);
            }
            this.placeholderId = i2;
            int i3 = this.fields | 128;
            this.fields = i3;
            this.placeholderDrawable = null;
            this.fields = i3 & (-65);
            return selfOrThrowIfLocked();
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    private <T> RequestOptions transform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65570, this, cls, transformation, z)) == null) {
            if (this.isAutoCloneEnabled) {
                return m111clone().transform(cls, transformation, z);
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
        return (RequestOptions) invokeLLZ.objValue;
    }

    @NonNull
    @CheckResult
    public <T> RequestOptions transform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048652, this, cls, transformation)) == null) ? transform(cls, transformation, true) : (RequestOptions) invokeLL.objValue;
    }
}
