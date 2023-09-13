package com.baidu.tieba.lego.card.utils;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ColorUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isColorInvalid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == Integer.MAX_VALUE : invokeI.booleanValue;
    }

    public ColorUtils() {
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

    public static int parseColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return Integer.MAX_VALUE;
            }
            if (str.length() != 0) {
                try {
                    if (!str.startsWith("#")) {
                        str = "#" + str;
                    }
                } catch (Exception unused) {
                    return Integer.MAX_VALUE;
                }
            }
            return Color.parseColor(str);
        }
        return invokeL.intValue;
    }
}
