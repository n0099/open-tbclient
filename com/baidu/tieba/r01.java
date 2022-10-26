package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, objArr, obj)) == null) {
            if (objArr == null) {
                return -1;
            }
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                if (objArr[i] == obj) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
