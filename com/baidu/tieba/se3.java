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
public class se3 extends qe3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public se3() {
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

    @Override // com.baidu.tieba.qe3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(pe3 pe3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pe3Var)) == null) {
            oe3 b = ue3.b(pe3Var.a);
            if (b == null) {
                if (!qe3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = pe3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (qe3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(pe3Var.c, Float.parseFloat(pe3Var.d));
                            }
                        } else {
                            b.putString(pe3Var.c, pe3Var.d);
                        }
                    } else {
                        b.putBoolean(pe3Var.c, Boolean.parseBoolean(pe3Var.d));
                    }
                } else {
                    b.putLong(pe3Var.c, Long.parseLong(pe3Var.d));
                }
            } else {
                b.putInt(pe3Var.c, Integer.parseInt(pe3Var.d));
            }
            if (qe3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + pe3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
