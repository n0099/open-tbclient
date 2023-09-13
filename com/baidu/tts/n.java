package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q1 a;
    public q0 b;
    public final String c;

    public n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = w0.a("MixStrategy", str);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q0 q0Var = this.a.c;
            q0 q0Var2 = this.b;
            if (q0Var2 == null) {
                if (q0Var == null) {
                    this.b = q0.a;
                    return true;
                }
                this.b = q0Var;
                return true;
            } else if (q0Var != null && q0Var2 != q0Var) {
                this.b = q0Var;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
