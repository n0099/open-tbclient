package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jh2 implements rg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jh2() {
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

    @Override // com.baidu.tieba.rg2
    @SuppressLint({"BDThrowableCheck"})
    public wg2 a(vg2 vg2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vg2Var)) == null) {
            int type = vg2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!qp1.a) {
                            return new mh2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + vg2Var);
                    }
                    return new ab2();
                }
                return os2.b();
            }
            return new mh2();
        }
        return (wg2) invokeL.objValue;
    }
}
