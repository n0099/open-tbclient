package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class w01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) {
            try {
                return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException(cls + " can't init new instance by default constructor.", e);
            }
        }
        return invokeL.objValue;
    }
}
