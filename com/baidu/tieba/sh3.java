package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sh3 extends qh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sh3() {
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

    @Override // com.baidu.tieba.qh3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(ph3 ph3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ph3Var)) == null) {
            oh3 b = uh3.b(ph3Var.a);
            if (b == null) {
                if (!qh3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = ph3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (qh3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(ph3Var.c, Float.parseFloat(ph3Var.d));
                            }
                        } else {
                            b.putString(ph3Var.c, ph3Var.d);
                        }
                    } else {
                        b.putBoolean(ph3Var.c, Boolean.parseBoolean(ph3Var.d));
                    }
                } else {
                    b.putLong(ph3Var.c, Long.parseLong(ph3Var.d));
                }
            } else {
                b.putInt(ph3Var.c, Integer.parseInt(ph3Var.d));
            }
            if (qh3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + ph3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
