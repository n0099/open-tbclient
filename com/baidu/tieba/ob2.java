package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ob2 implements wa2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ob2() {
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

    @Override // com.baidu.tieba.wa2
    @SuppressLint({"BDThrowableCheck"})
    public bb2 a(ab2 ab2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ab2Var)) == null) {
            int type = ab2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!vj1.a) {
                            return new rb2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + ab2Var);
                    }
                    return new f52();
                }
                return tm2.b();
            }
            return new rb2();
        }
        return (bb2) invokeL.objValue;
    }
}
