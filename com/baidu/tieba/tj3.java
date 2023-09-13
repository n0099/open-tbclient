package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tj3 extends rj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tj3() {
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

    @Override // com.baidu.tieba.rj3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(qj3 qj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qj3Var)) == null) {
            pj3 b = vj3.b(qj3Var.a);
            if (b == null) {
                if (!rj3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = qj3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (rj3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(qj3Var.c, Float.parseFloat(qj3Var.d));
                            }
                        } else {
                            b.putString(qj3Var.c, qj3Var.d);
                        }
                    } else {
                        b.putBoolean(qj3Var.c, Boolean.parseBoolean(qj3Var.d));
                    }
                } else {
                    b.putLong(qj3Var.c, Long.parseLong(qj3Var.d));
                }
            } else {
                b.putInt(qj3Var.c, Integer.parseInt(qj3Var.d));
            }
            if (rj3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + qj3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
