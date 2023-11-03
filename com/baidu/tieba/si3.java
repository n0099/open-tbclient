package com.baidu.tieba;

import androidx.annotation.ColorInt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class si3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? ((int) (((((double) ((16711680 & i) >> 16)) * 0.299d) + (((double) ((65280 & i) >> 8)) * 0.587d)) + (((double) (i & 255)) * 0.114d))) >= 220 : invokeI.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return V8Engine.toColorRGBA(str);
        }
        return (String) invokeL.objValue;
    }
}
