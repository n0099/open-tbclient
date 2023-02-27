package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s16 a() {
        InterceptResult invokeV;
        s16 s16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t16.class) {
                if (a == null) {
                    a = new s16();
                }
                s16Var = a;
            }
            return s16Var;
        }
        return (s16) invokeV.objValue;
    }
}
