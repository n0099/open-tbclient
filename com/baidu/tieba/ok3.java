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
public class ok3 extends mk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ok3() {
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

    @Override // com.baidu.tieba.mk3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(lk3 lk3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lk3Var)) == null) {
            kk3 b = qk3.b(lk3Var.a);
            if (b == null) {
                if (!mk3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = lk3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (mk3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(lk3Var.c, Float.parseFloat(lk3Var.d));
                            }
                        } else {
                            b.putString(lk3Var.c, lk3Var.d);
                        }
                    } else {
                        b.putBoolean(lk3Var.c, Boolean.parseBoolean(lk3Var.d));
                    }
                } else {
                    b.putLong(lk3Var.c, Long.parseLong(lk3Var.d));
                }
            } else {
                b.putInt(lk3Var.c, Integer.parseInt(lk3Var.d));
            }
            if (mk3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + lk3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
