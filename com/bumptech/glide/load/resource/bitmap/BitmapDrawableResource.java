package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;
/* loaded from: classes7.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool bitmapPool;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, BitmapPool bitmapPool) {
        super(bitmapDrawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapDrawable, bitmapPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return BitmapDrawable.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Util.getBitmapByteSize(((BitmapDrawable) this.drawable).getBitmap());
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.bitmapPool.put(((BitmapDrawable) this.drawable).getBitmap());
        }
    }
}
