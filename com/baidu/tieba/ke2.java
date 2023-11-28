package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ke2 implements sd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ke2() {
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

    @Override // com.baidu.tieba.sd2
    @SuppressLint({"BDThrowableCheck"})
    public xd2 a(wd2 wd2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wd2Var)) == null) {
            int b = wd2Var.b();
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        if (!sm1.a) {
                            return new ne2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + wd2Var);
                    }
                    return new b82();
                }
                return pp2.b();
            }
            return new ne2();
        }
        return (xd2) invokeL.objValue;
    }
}
