package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
/* loaded from: classes7.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    public static /* synthetic */ Interceptable $ic;
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

    public RequestOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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
    public static RequestOptions noAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (noTransformOptions == null) {
                noTransformOptions = new RequestOptions().dontTransform().autoClone();
            }
            return noTransformOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transformation)) == null) {
            return new RequestOptions().transform(transformation);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            return new RequestOptions().decode(cls);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, diskCacheStrategy)) == null) {
            return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downsampleStrategy)) == null) {
            return new RequestOptions().downsample(downsampleStrategy);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, compressFormat)) == null) {
            return new RequestOptions().encodeFormat(compressFormat);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return new RequestOptions().encodeQuality(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return new RequestOptions().error(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, decodeFormat)) == null) {
            return new RequestOptions().format(decodeFormat);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65550, null, j)) == null) {
            return new RequestOptions().frame(j);
        }
        return (RequestOptions) invokeJ.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            return overrideOf(i, i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            return new RequestOptions().placeholder(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, priority)) == null) {
            return new RequestOptions().priority(priority);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, key)) == null) {
            return new RequestOptions().signature(key);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65560, null, f)) == null) {
            return new RequestOptions().sizeMultiplier(f);
        }
        return (RequestOptions) invokeF.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            return new RequestOptions().timeout(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, drawable)) == null) {
            return new RequestOptions().error(drawable);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, drawable)) == null) {
            return new RequestOptions().placeholder(drawable);
        }
        return (RequestOptions) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, option, t)) == null) {
            return new RequestOptions().set(option, t);
        }
        return (RequestOptions) invokeLL.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65555, null, i, i2)) == null) {
            return new RequestOptions().override(i, i2);
        }
        return (RequestOptions) invokeII.objValue;
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65561, null, z)) == null) {
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
}
