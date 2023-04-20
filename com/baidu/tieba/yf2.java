package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yf2 implements gf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yf2() {
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

    @Override // com.baidu.tieba.gf2
    @SuppressLint({"BDThrowableCheck"})
    public lf2 a(kf2 kf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kf2Var)) == null) {
            int type = kf2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!fo1.a) {
                            return new bg2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + kf2Var);
                    }
                    return new p92();
                }
                return dr2.b();
            }
            return new bg2();
        }
        return (lf2) invokeL.objValue;
    }
}
