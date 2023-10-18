package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sd2 implements ad2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sd2() {
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

    @Override // com.baidu.tieba.ad2
    @SuppressLint({"BDThrowableCheck"})
    public fd2 a(ed2 ed2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ed2Var)) == null) {
            int b = ed2Var.b();
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        if (!am1.a) {
                            return new vd2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + ed2Var);
                    }
                    return new j72();
                }
                return xo2.b();
            }
            return new vd2();
        }
        return (fd2) invokeL.objValue;
    }
}
