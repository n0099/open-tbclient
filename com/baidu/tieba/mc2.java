package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mc2 implements ub2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mc2() {
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

    @Override // com.baidu.tieba.ub2
    @SuppressLint({"BDThrowableCheck"})
    public zb2 a(yb2 yb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yb2Var)) == null) {
            int type = yb2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!tk1.a) {
                            return new pc2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + yb2Var);
                    }
                    return new d62();
                }
                return rn2.b();
            }
            return new pc2();
        }
        return (zb2) invokeL.objValue;
    }
}
