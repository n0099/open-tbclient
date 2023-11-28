package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wg {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vg a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vg a() {
        InterceptResult invokeV;
        vg vgVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wg.class) {
                if (a == null) {
                    a = new vg();
                }
                vgVar = a;
            }
            return vgVar;
        }
        return (vg) invokeV.objValue;
    }
}
