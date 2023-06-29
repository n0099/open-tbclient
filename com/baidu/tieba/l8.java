package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
/* loaded from: classes6.dex */
public final class l8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Class cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, cls, i)) == null) {
            return Array.newInstance(cls, i);
        }
        return invokeLI.objValue;
    }

    public static void b(Object obj, int i, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, obj, i, obj2) == null) {
            Array.set(obj, i, obj2);
        }
    }
}
