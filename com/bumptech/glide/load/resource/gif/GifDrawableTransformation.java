package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
/* loaded from: classes11.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transformation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wrapped = (Transformation) Preconditions.checkNotNull(transformation);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof GifDrawableTransformation) {
                return this.wrapped.equals(((GifDrawableTransformation) obj).wrapped);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.wrapped.hashCode() : invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<GifDrawable> transform(@NonNull Context context, @NonNull Resource<GifDrawable> resource, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, context, resource, i2, i3)) == null) {
            GifDrawable gifDrawable = resource.get();
            Resource<Bitmap> bitmapResource = new BitmapResource(gifDrawable.getFirstFrame(), Glide.get(context).getBitmapPool());
            Resource<Bitmap> transform = this.wrapped.transform(context, bitmapResource, i2, i3);
            if (!bitmapResource.equals(transform)) {
                bitmapResource.recycle();
            }
            gifDrawable.setFrameTransformation(this.wrapped, transform.get());
            return resource;
        }
        return (Resource) invokeLLII.objValue;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, messageDigest) == null) {
            this.wrapped.updateDiskCacheKey(messageDigest);
        }
    }
}
