package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes9.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ID_PATH_SEGMENTS = 1;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context.getApplicationContext();
    }

    @NonNull
    private Context getContextForPackage(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, uri, str)) == null) {
            try {
                return this.context.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
            }
        }
        return (Context) invokeLL.objValue;
    }

    @DrawableRes
    private int loadResourceIdFromUri(Uri uri) {
        InterceptResult invokeL;
        Integer valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 2) {
                String authority = uri.getAuthority();
                valueOf = Integer.valueOf(this.context.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), authority));
            } else {
                if (pathSegments.size() == 1) {
                    try {
                        valueOf = Integer.valueOf(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                valueOf = null;
            }
            if (valueOf != null) {
                if (valueOf.intValue() != 0) {
                    return valueOf.intValue();
                }
                throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
            }
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public Resource<Drawable> decode(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
            int loadResourceIdFromUri = loadResourceIdFromUri(uri);
            String authority = uri.getAuthority();
            return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, authority.equals(this.context.getPackageName()) ? this.context : getContextForPackage(uri, authority), loadResourceIdFromUri));
        }
        return (Resource) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull Uri uri, @NonNull Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, options)) == null) ? uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME) : invokeLL.booleanValue;
    }
}
