package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class z54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Integer a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1727084929) {
                    if (hashCode != -1538208320) {
                        if (hashCode == 155362205 && str.equals("menuAddToLauncher")) {
                            return 35;
                        }
                    } else if (str.equals("menuShare")) {
                        return 4;
                    }
                } else if (str.equals("menuAttention")) {
                    return 38;
                }
            }
            return null;
        }
        return (Integer) invokeL.objValue;
    }
}
