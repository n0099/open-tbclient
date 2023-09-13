package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wab {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vab a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vab a() {
        InterceptResult invokeV;
        vab vabVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wab.class) {
                if (a == null) {
                    a = new vab();
                }
                vabVar = a;
            }
            return vabVar;
        }
        return (vab) invokeV.objValue;
    }
}
