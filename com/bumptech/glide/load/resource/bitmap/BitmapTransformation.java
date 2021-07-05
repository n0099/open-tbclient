package com.bumptech.glide.load.resource.bitmap;

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
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
/* loaded from: classes6.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapTransformation() {
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

    public abstract Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public final Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, resource, i2, i3)) == null) {
            if (Util.isValidDimensions(i2, i3)) {
                BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
                Bitmap bitmap = resource.get();
                if (i2 == Integer.MIN_VALUE) {
                    i2 = bitmap.getWidth();
                }
                if (i3 == Integer.MIN_VALUE) {
                    i3 = bitmap.getHeight();
                }
                Bitmap transform = transform(bitmapPool, bitmap, i2, i3);
                return bitmap.equals(transform) ? resource : BitmapResource.obtain(transform, bitmapPool);
            }
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        return (Resource) invokeLLII.objValue;
    }
}
