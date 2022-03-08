package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
/* loaded from: classes7.dex */
public final class MediaStoreUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MINI_THUMB_HEIGHT = 384;
    public static final int MINI_THUMB_WIDTH = 512;
    public transient /* synthetic */ FieldHolder $fh;

    public MediaStoreUtil() {
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

    public static boolean isMediaStoreImageUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) ? isMediaStoreUri(uri) && !isVideoUri(uri) : invokeL.booleanValue;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) ? uri != null && "content".equals(uri.getScheme()) && VodClient.PATH_MEDIA.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) ? isMediaStoreUri(uri) && isVideoUri(uri) : invokeL.booleanValue;
    }

    public static boolean isThumbnailSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384 : invokeII.booleanValue;
    }

    public static boolean isVideoUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) ? uri.getPathSegments().contains("video") : invokeL.booleanValue;
    }
}
