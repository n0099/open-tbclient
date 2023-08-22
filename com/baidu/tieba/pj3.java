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
public class pj3 extends nj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pj3() {
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

    @Override // com.baidu.tieba.nj3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(mj3 mj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mj3Var)) == null) {
            lj3 b = rj3.b(mj3Var.a);
            if (b == null) {
                if (!nj3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = mj3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (nj3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(mj3Var.c, Float.parseFloat(mj3Var.d));
                            }
                        } else {
                            b.putString(mj3Var.c, mj3Var.d);
                        }
                    } else {
                        b.putBoolean(mj3Var.c, Boolean.parseBoolean(mj3Var.d));
                    }
                } else {
                    b.putLong(mj3Var.c, Long.parseLong(mj3Var.d));
                }
            } else {
                b.putInt(mj3Var.c, Integer.parseInt(mj3Var.d));
            }
            if (nj3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + mj3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
