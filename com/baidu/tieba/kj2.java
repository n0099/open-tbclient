package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kj2 implements si2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kj2() {
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

    @Override // com.baidu.tieba.si2
    @SuppressLint({"BDThrowableCheck"})
    public xi2 a(wi2 wi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wi2Var)) == null) {
            int type = wi2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!rr1.a) {
                            return new nj2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + wi2Var);
                    }
                    return new bd2();
                }
                return pu2.b();
            }
            return new nj2();
        }
        return (xi2) invokeL.objValue;
    }
}
