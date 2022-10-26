package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
public class RequestOptions extends BaseRequestOptions {
    public static /* synthetic */ Interceptable $ic;
    public static RequestOptions centerCropOptions;
    public static RequestOptions centerInsideOptions;
    public static RequestOptions circleCropOptions;
    public static RequestOptions fitCenterOptions;
    public static RequestOptions noAnimationOptions;
    public static RequestOptions noTransformOptions;
    public static RequestOptions skipMemoryCacheFalseOptions;
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

    public static RequestOptions centerCropTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (centerCropOptions == null) {
                centerCropOptions = (RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).autoClone();
            }
            return centerCropOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public static RequestOptions centerInsideTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (centerInsideOptions == null) {
                centerInsideOptions = (RequestOptions) ((RequestOptions) new RequestOptions().centerInside()).autoClone();
            }
            return centerInsideOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public static RequestOptions circleCropTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (circleCropOptions == null) {
                circleCropOptions = (RequestOptions) ((RequestOptions) new RequestOptions().circleCrop()).autoClone();
            }
            return circleCropOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public static RequestOptions fitCenterTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (fitCenterOptions == null) {
                fitCenterOptions = (RequestOptions) ((RequestOptions) new RequestOptions().fitCenter()).autoClone();
            }
            return fitCenterOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public static RequestOptions noAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (noAnimationOptions == null) {
                noAnimationOptions = (RequestOptions) ((RequestOptions) new RequestOptions().dontAnimate()).autoClone();
            }
            return noAnimationOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public static RequestOptions noTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (noTransformOptions == null) {
                noTransformOptions = (RequestOptions) ((RequestOptions) new RequestOptions().dontTransform()).autoClone();
            }
            return noTransformOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public static RequestOptions bitmapTransform(Transformation transformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transformation)) == null) {
            return (RequestOptions) new RequestOptions().transform(transformation);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions decodeTypeOf(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            return (RequestOptions) new RequestOptions().decode(cls);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, diskCacheStrategy)) == null) {
            return (RequestOptions) new RequestOptions().diskCacheStrategy(diskCacheStrategy);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downsampleStrategy)) == null) {
            return (RequestOptions) new RequestOptions().downsample(downsampleStrategy);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, compressFormat)) == null) {
            return (RequestOptions) new RequestOptions().encodeFormat(compressFormat);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions encodeQualityOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return (RequestOptions) new RequestOptions().encodeQuality(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    public static RequestOptions errorOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return (RequestOptions) new RequestOptions().error(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    public static RequestOptions formatOf(DecodeFormat decodeFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, decodeFormat)) == null) {
            return (RequestOptions) new RequestOptions().format(decodeFormat);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions frameOf(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65550, null, j)) == null) {
            return (RequestOptions) new RequestOptions().frame(j);
        }
        return (RequestOptions) invokeJ.objValue;
    }

    public static RequestOptions overrideOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            return overrideOf(i, i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    public static RequestOptions placeholderOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            return (RequestOptions) new RequestOptions().placeholder(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    public static RequestOptions priorityOf(Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, priority)) == null) {
            return (RequestOptions) new RequestOptions().priority(priority);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions signatureOf(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, key)) == null) {
            return (RequestOptions) new RequestOptions().signature(key);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions sizeMultiplierOf(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65560, null, f)) == null) {
            return (RequestOptions) new RequestOptions().sizeMultiplier(f);
        }
        return (RequestOptions) invokeF.objValue;
    }

    public static RequestOptions timeoutOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            return (RequestOptions) new RequestOptions().timeout(i);
        }
        return (RequestOptions) invokeI.objValue;
    }

    public static RequestOptions errorOf(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, drawable)) == null) {
            return (RequestOptions) new RequestOptions().error(drawable);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions placeholderOf(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, drawable)) == null) {
            return (RequestOptions) new RequestOptions().placeholder(drawable);
        }
        return (RequestOptions) invokeL.objValue;
    }

    public static RequestOptions option(Option option, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, option, obj)) == null) {
            return (RequestOptions) new RequestOptions().set(option, obj);
        }
        return (RequestOptions) invokeLL.objValue;
    }

    public static RequestOptions overrideOf(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65555, null, i, i2)) == null) {
            return (RequestOptions) new RequestOptions().override(i, i2);
        }
        return (RequestOptions) invokeII.objValue;
    }

    public static RequestOptions skipMemoryCacheOf(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65561, null, z)) == null) {
            if (z) {
                if (skipMemoryCacheTrueOptions == null) {
                    skipMemoryCacheTrueOptions = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(true)).autoClone();
                }
                return skipMemoryCacheTrueOptions;
            }
            if (skipMemoryCacheFalseOptions == null) {
                skipMemoryCacheFalseOptions = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(false)).autoClone();
            }
            return skipMemoryCacheFalseOptions;
        }
        return (RequestOptions) invokeZ.objValue;
    }
}
