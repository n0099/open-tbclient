package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yoa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xoa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xoa a() {
        InterceptResult invokeV;
        xoa xoaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yoa.class) {
                if (a == null) {
                    a = new xoa();
                }
                xoaVar = a;
            }
            return xoaVar;
        }
        return (xoa) invokeV.objValue;
    }
}
