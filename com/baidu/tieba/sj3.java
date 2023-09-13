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
/* loaded from: classes8.dex */
public class sj3 extends rj3 {
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

    @Override // com.baidu.tieba.rj3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(qj3 qj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qj3Var)) == null) {
            Bundle bundle = new Bundle();
            pj3 b = vj3.b(qj3Var.a);
            if (b == null) {
                if (!rj3.a) {
                    return bundle;
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
                                bundle.putFloat("result_value", b.getFloat(qj3Var.c, Float.parseFloat(qj3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(qj3Var.c, qj3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(qj3Var.c, Boolean.parseBoolean(qj3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(qj3Var.c, Long.parseLong(qj3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(qj3Var.c, Integer.parseInt(qj3Var.d)));
            }
            if (rj3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + qj3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
