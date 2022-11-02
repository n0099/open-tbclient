package com.bumptech.glide.load.engine.bitmap_recycle;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IntegerArrayPool";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    public IntegerArrayAdapter() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getArrayLength(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr)) == null) {
            return iArr.length;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int[] newArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return new int[i];
        }
        return (int[]) invokeI.objValue;
    }
}
