package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xf2 implements ff2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xf2() {
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

    @Override // com.baidu.tieba.ff2
    @SuppressLint({"BDThrowableCheck"})
    public kf2 a(jf2 jf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jf2Var)) == null) {
            int type = jf2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!eo1.a) {
                            return new ag2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + jf2Var);
                    }
                    return new o92();
                }
                return cr2.b();
            }
            return new ag2();
        }
        return (kf2) invokeL.objValue;
    }
}
