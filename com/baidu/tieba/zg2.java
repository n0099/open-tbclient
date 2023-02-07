package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zg2 implements hg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zg2() {
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

    @Override // com.baidu.tieba.hg2
    @SuppressLint({"BDThrowableCheck"})
    public mg2 a(lg2 lg2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lg2Var)) == null) {
            int type = lg2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!gp1.a) {
                            return new ch2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + lg2Var);
                    }
                    return new qa2();
                }
                return es2.b();
            }
            return new ch2();
        }
        return (mg2) invokeL.objValue;
    }
}
