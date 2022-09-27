package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vi8 a() {
        InterceptResult invokeV;
        vi8 vi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wi8.class) {
                if (a == null) {
                    a = new vi8();
                }
                vi8Var = a;
            }
            return vi8Var;
        }
        return (vi8) invokeV.objValue;
    }
}
