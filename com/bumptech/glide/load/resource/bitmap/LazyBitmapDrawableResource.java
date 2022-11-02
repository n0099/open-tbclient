package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes7.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Resource<Bitmap> bitmapResource;
    public final Resources resources;

    public LazyBitmapDrawableResource(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, resource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resources = (Resources) Preconditions.checkNotNull(resources);
        this.bitmapResource = (Resource) Preconditions.checkNotNull(resource);
    }

    @Nullable
    public static Resource<BitmapDrawable> obtain(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, resource)) == null) {
            if (resource == null) {
                return null;
            }
            return new LazyBitmapDrawableResource(resources, resource);
        }
        return (Resource) invokeLL.objValue;
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, bitmap)) == null) {
            return (LazyBitmapDrawableResource) obtain(context.getResources(), BitmapResource.obtain(bitmap, Glide.get(context).getBitmapPool()));
        }
        return (LazyBitmapDrawableResource) invokeLL.objValue;
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, resources, bitmapPool, bitmap)) == null) {
            return (LazyBitmapDrawableResource) obtain(resources, BitmapResource.obtain(bitmap, bitmapPool));
        }
        return (LazyBitmapDrawableResource) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public BitmapDrawable get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new BitmapDrawable(this.resources, this.bitmapResource.get());
        }
        return (BitmapDrawable) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return BitmapDrawable.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bitmapResource.getSize();
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Resource<Bitmap> resource = this.bitmapResource;
            if (resource instanceof Initializable) {
                ((Initializable) resource).initialize();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.bitmapResource.recycle();
        }
    }
}
