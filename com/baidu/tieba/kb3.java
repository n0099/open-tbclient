package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kb3 extends ib3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kb3() {
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

    @Override // com.baidu.tieba.ib3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(hb3 hb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hb3Var)) == null) {
            gb3 b = mb3.b(hb3Var.a);
            if (b == null) {
                if (!ib3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = hb3Var.b;
            if (i == 1) {
                b.putInt(hb3Var.c, Integer.parseInt(hb3Var.d));
            } else if (i == 2) {
                b.putLong(hb3Var.c, Long.parseLong(hb3Var.d));
            } else if (i == 3) {
                b.putBoolean(hb3Var.c, Boolean.parseBoolean(hb3Var.d));
            } else if (i == 4) {
                b.putString(hb3Var.c, hb3Var.d);
            } else if (i != 5) {
                if (ib3.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(hb3Var.c, Float.parseFloat(hb3Var.d));
            }
            if (ib3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + hb3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
