package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ui8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ui8 a() {
        InterceptResult invokeV;
        ui8 ui8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vi8.class) {
                if (a == null) {
                    a = new ui8();
                }
                ui8Var = a;
            }
            return ui8Var;
        }
        return (ui8) invokeV.objValue;
    }
}
