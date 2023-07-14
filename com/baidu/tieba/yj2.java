package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yj2 implements gj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yj2() {
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

    @Override // com.baidu.tieba.gj2
    @SuppressLint({"BDThrowableCheck"})
    public lj2 a(kj2 kj2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kj2Var)) == null) {
            int type = kj2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!fs1.a) {
                            return new bk2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + kj2Var);
                    }
                    return new pd2();
                }
                return dv2.b();
            }
            return new bk2();
        }
        return (lj2) invokeL.objValue;
    }
}
