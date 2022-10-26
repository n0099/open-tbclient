package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.facebook.common.util.UriUtil;
import java.util.List;
/* loaded from: classes7.dex */
public class ResourceDrawableDecoder implements ResourceDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANDROID_PACKAGE_NAME = "android";
    public static final int ID_PATH_SEGMENTS = 1;
    public static final int MISSING_RESOURCE_ID = 0;
    public static final int NAME_PATH_SEGMENT_INDEX = 1;
    public static final int NAME_URI_PATH_SEGMENTS = 2;
    public static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    public static final int TYPE_PATH_SEGMENT_INDEX = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;

    public ResourceDrawableDecoder(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context.getApplicationContext();
    }

    private int findResourceIdFromResourceIdUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            try {
                return Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
            }
        }
        return invokeL.intValue;
    }

    private Context findContextForPackage(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, uri, str)) == null) {
            if (str.equals(this.context.getPackageName())) {
                return this.context;
            }
            try {
                return this.context.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (str.contains(this.context.getPackageName())) {
                    return this.context;
                }
                throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
            }
        }
        return (Context) invokeLL.objValue;
    }

    private int findResourceIdFromTypeAndNameResourceUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            String authority = uri.getAuthority();
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            int identifier = context.getResources().getIdentifier(str2, str, authority);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier != 0) {
                return identifier;
            }
            throw new IllegalArgumentException("Failed to find resource id for: " + uri);
        }
        return invokeLL.intValue;
    }

    private int findResourceIdFromUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 2) {
                return findResourceIdFromTypeAndNameResourceUri(context, uri);
            }
            if (pathSegments.size() == 1) {
                return findResourceIdFromResourceIdUri(uri);
            }
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Uri uri, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{uri, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            Context findContextForPackage = findContextForPackage(uri, uri.getAuthority());
            return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, findContextForPackage, findResourceIdFromUri(findContextForPackage, uri)));
        }
        return (Resource) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Uri uri, Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, options)) == null) {
            return uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
        }
        return invokeLL.booleanValue;
    }
}
