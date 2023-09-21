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
public class sj3 extends qj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sj3() {
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

    @Override // com.baidu.tieba.qj3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(pj3 pj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pj3Var)) == null) {
            oj3 b = uj3.b(pj3Var.a);
            if (b == null) {
                if (!qj3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = pj3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (qj3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(pj3Var.c, Float.parseFloat(pj3Var.d));
                            }
                        } else {
                            b.putString(pj3Var.c, pj3Var.d);
                        }
                    } else {
                        b.putBoolean(pj3Var.c, Boolean.parseBoolean(pj3Var.d));
                    }
                } else {
                    b.putLong(pj3Var.c, Long.parseLong(pj3Var.d));
                }
            } else {
                b.putInt(pj3Var.c, Integer.parseInt(pj3Var.d));
            }
            if (qj3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + pj3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
