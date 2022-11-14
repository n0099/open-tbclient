package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "InteractiveABConfig")
/* loaded from: classes4.dex */
public final class js0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (ks0.a() != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (ks0.a() != 0 && ks0.a() != 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
