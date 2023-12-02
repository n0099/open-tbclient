package com.baidu.tieba;

import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class vz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Column[] c();

    public abstract nz0[] d();

    public abstract nz0[][] e();

    public abstract nz0[] f();

    public abstract String g();

    public vz0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static nz0 a(int i, String str, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)})) == null) {
            return b(i, str, str2, i2, 0);
        }
        return (nz0) invokeCommon.objValue;
    }

    public static nz0 b(int i, String str, String str2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return new nz0(i, str, str2, i2, i3);
        }
        return (nz0) invokeCommon.objValue;
    }
}
