package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class je2 implements rd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public je2() {
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

    @Override // com.baidu.tieba.rd2
    @SuppressLint({"BDThrowableCheck"})
    public wd2 a(vd2 vd2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vd2Var)) == null) {
            int b = vd2Var.b();
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        if (!rm1.a) {
                            return new me2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + vd2Var);
                    }
                    return new a82();
                }
                return op2.b();
            }
            return new me2();
        }
        return (wd2) invokeL.objValue;
    }
}
