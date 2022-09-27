package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes6.dex */
public class wb3 extends vb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wb3() {
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

    @Override // com.baidu.tieba.vb3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(ub3 ub3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ub3Var)) == null) {
            Bundle bundle = new Bundle();
            tb3 b = zb3.b(ub3Var.a);
            if (b == null) {
                if (vb3.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = ub3Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(ub3Var.c, Integer.parseInt(ub3Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(ub3Var.c, Long.parseLong(ub3Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(ub3Var.c, Boolean.parseBoolean(ub3Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(ub3Var.c, ub3Var.d));
            } else if (i != 5) {
                if (vb3.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(ub3Var.c, Float.parseFloat(ub3Var.d)));
            }
            if (vb3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + ub3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
