package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes9.dex */
public class z0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Hashtable<u0, y0> a;

    public z0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Hashtable<>();
    }

    public static z0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (z0.class) {
                    if (b == null) {
                        b = new z0();
                    }
                }
            }
            return b;
        }
        return (z0) invokeV.objValue;
    }

    public d a(u0 u0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u0Var)) == null) {
            y0 y0Var = this.a.get(u0Var);
            if (y0Var == null) {
                y0Var = new y0(u0Var);
                this.a.put(u0Var, y0Var);
            }
            d dVar = new d();
            dVar.d = y0Var;
            return dVar;
        }
        return (d) invokeL.objValue;
    }
}
