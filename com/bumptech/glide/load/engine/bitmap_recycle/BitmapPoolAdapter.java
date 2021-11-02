package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BitmapPoolAdapter implements BitmapPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapPoolAdapter() {
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

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, config)) == null) ? Bitmap.createBitmap(i2, i3, config) : (Bitmap) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, config)) == null) ? get(i2, i3, config) : (Bitmap) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void put(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            bitmap.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
        }
    }
}
