package com.baidu.tieba;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TabBarLogic.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class lt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static nt7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new mt7();
        }
        return (nt7) invokeV.objValue;
    }

    @ColorInt
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return SkinManager.getColor(R.color.CAM_X0107);
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        }
        return invokeV.intValue;
    }
}
