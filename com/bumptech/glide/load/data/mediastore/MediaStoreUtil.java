package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class MediaStoreUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MINI_THUMB_HEIGHT = 384;
    public static final int MINI_THUMB_WIDTH = 512;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isThumbnailSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) ? i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384 : invokeII.booleanValue;
    }

    public MediaStoreUtil() {
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

    public static boolean isMediaStoreImageUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            if (isMediaStoreUri(uri) && !isVideoUri(uri)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            if (uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            if (isMediaStoreUri(uri) && isVideoUri(uri)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isVideoUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            return uri.getPathSegments().contains("video");
        }
        return invokeL.booleanValue;
    }
}
