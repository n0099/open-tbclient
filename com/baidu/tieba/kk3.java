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
public class kk3 extends ik3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kk3() {
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

    @Override // com.baidu.tieba.ik3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(hk3 hk3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hk3Var)) == null) {
            gk3 b = mk3.b(hk3Var.a);
            if (b == null) {
                if (!ik3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = hk3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (ik3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(hk3Var.c, Float.parseFloat(hk3Var.d));
                            }
                        } else {
                            b.putString(hk3Var.c, hk3Var.d);
                        }
                    } else {
                        b.putBoolean(hk3Var.c, Boolean.parseBoolean(hk3Var.d));
                    }
                } else {
                    b.putLong(hk3Var.c, Long.parseLong(hk3Var.d));
                }
            } else {
                b.putInt(hk3Var.c, Integer.parseInt(hk3Var.d));
            }
            if (ik3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + hk3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
