package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
@Deprecated
/* loaded from: classes7.dex */
public class BitmapDrawableTransformation implements Transformation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Transformation wrapped;

    public static Resource convertToDrawableResource(Resource resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, resource)) == null) ? resource : (Resource) invokeL.objValue;
    }

    public BitmapDrawableTransformation(Transformation transformation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transformation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wrapped = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(transformation, false));
    }

    public static Resource convertToBitmapDrawableResource(Resource resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, resource)) == null) {
            if (resource.get() instanceof BitmapDrawable) {
                return resource;
            }
            throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
        }
        return (Resource) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof BitmapDrawableTransformation) {
                return this.wrapped.equals(((BitmapDrawableTransformation) obj).wrapped);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, messageDigest) == null) {
            this.wrapped.updateDiskCacheKey(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.wrapped.hashCode();
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource transform(Context context, Resource resource, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, context, resource, i, i2)) == null) {
            return convertToBitmapDrawableResource(this.wrapped.transform(context, convertToDrawableResource(resource), i, i2));
        }
        return (Resource) invokeLLII.objValue;
    }
}
