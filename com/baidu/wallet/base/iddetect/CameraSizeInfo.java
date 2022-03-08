package com.baidu.wallet.base.iddetect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CameraSizeInfo implements Comparable<CameraSizeInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mHeight;
    public float mHeightRatio;
    public boolean mIsCompareRatio;
    public float mRatioDeta;
    public int mWidth;

    public CameraSizeInfo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsCompareRatio = false;
        this.mWidth = i2;
        this.mHeight = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(CameraSizeInfo cameraSizeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cameraSizeInfo)) == null) {
            if (this.mIsCompareRatio) {
                return this.mRatioDeta < cameraSizeInfo.mRatioDeta ? -1 : 1;
            }
            int i2 = this.mHeight;
            int i3 = cameraSizeInfo.mHeight;
            if (i2 < i3) {
                return -1;
            }
            return (i2 <= i3 && this.mWidth < cameraSizeInfo.mWidth) ? -1 : 1;
        }
        return invokeL.intValue;
    }
}
