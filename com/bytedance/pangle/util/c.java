package com.bytedance.pangle.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, objArr)) == null) {
            if (objArr != null && objArr.length != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, objArr, obj)) == null) {
            if (objArr != null) {
                i = 0;
                while (i < objArr.length) {
                    if (objArr[i] == obj || (objArr[i] != null && objArr[i].equals(obj))) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
            if (i == -1) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, objArr, objArr2)) == null) {
            if (objArr2 == null) {
                return true;
            }
            for (Object obj : objArr2) {
                if (!a(objArr, obj)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
