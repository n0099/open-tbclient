package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lk3 extends jk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lk3() {
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

    @Override // com.baidu.tieba.jk3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(ik3 ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ik3Var)) == null) {
            hk3 b = nk3.b(ik3Var.a);
            if (b == null) {
                if (!jk3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = ik3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (jk3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(ik3Var.c, Float.parseFloat(ik3Var.d));
                            }
                        } else {
                            b.putString(ik3Var.c, ik3Var.d);
                        }
                    } else {
                        b.putBoolean(ik3Var.c, Boolean.parseBoolean(ik3Var.d));
                    }
                } else {
                    b.putLong(ik3Var.c, Long.parseLong(ik3Var.d));
                }
            } else {
                b.putInt(ik3Var.c, Integer.parseInt(ik3Var.d));
            }
            if (jk3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + ik3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
