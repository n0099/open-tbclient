package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wf2 implements ef2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wf2() {
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

    @Override // com.baidu.tieba.ef2
    @SuppressLint({"BDThrowableCheck"})
    public jf2 a(if2 if2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, if2Var)) == null) {
            int type = if2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!do1.a) {
                            return new zf2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + if2Var);
                    }
                    return new n92();
                }
                return br2.b();
            }
            return new zf2();
        }
        return (jf2) invokeL.objValue;
    }
}
