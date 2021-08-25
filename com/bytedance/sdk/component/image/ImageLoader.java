package com.bytedance.sdk.component.image;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.c.a;
import com.bytedance.sdk.component.image.c.b;
import com.bytedance.sdk.component.image.c.c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class ImageLoader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f64895a;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void clearAllCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            clearDiskCache(0.0d);
            clearMemoryCache(0.0d);
        }
    }

    public static void clearCache(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)}) == null) {
            clearMemoryCache(d2);
            clearDiskCache(d2);
        }
    }

    public static void clearDiskCache(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2)}) == null) && f64895a) {
            b.a().d().a(d2);
        }
    }

    public static void clearMemoryCache(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d2)}) == null) && f64895a) {
            b.a().b().a(d2);
            b.a().c().a(d2);
        }
    }

    public static IImageLoader from(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? new a.b().from(str) : (IImageLoader) invokeL.objValue;
    }

    @Nullable
    public static InputStream getCacheStream(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            if (f64895a) {
                if (TextUtils.isEmpty(str2)) {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    str2 = com.bytedance.sdk.component.image.c.c.b.a(str);
                }
                byte[] a2 = b.a().c().a((IRawCache) str2);
                if (a2 != null) {
                    return new ByteArrayInputStream(a2);
                }
                return b.a().d().getCacheStream(str2);
            }
            return null;
        }
        return (InputStream) invokeLL.objValue;
    }

    public static void initialize(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            initialize(context, null);
        }
    }

    public static void initialize(Context context, LoadConfig loadConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, loadConfig) == null) {
            if (f64895a) {
                c.a(com.kwad.sdk.core.imageloader.core.ImageLoader.TAG, "already init!");
            }
            f64895a = true;
            if (loadConfig == null) {
                loadConfig = LoadConfig.getDefaultConfig(context);
            }
            b.a(context, loadConfig);
        }
    }
}
