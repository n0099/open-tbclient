package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ph2 implements xg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ph2() {
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

    @Override // com.baidu.tieba.xg2
    @SuppressLint({"BDThrowableCheck"})
    public ch2 a(bh2 bh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bh2Var)) == null) {
            int type = bh2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!wp1.a) {
                            return new sh2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + bh2Var);
                    }
                    return new gb2();
                }
                return us2.b();
            }
            return new sh2();
        }
        return (ch2) invokeL.objValue;
    }
}
