package com.baidu.tieba;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TabBarLogic.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class rr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static tr6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new sr6() : (tr6) invokeV.objValue;
    }

    @ColorInt
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? SkinManager.getColor(R.color.CAM_X0107) : invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds42) : invokeV.intValue;
    }
}
