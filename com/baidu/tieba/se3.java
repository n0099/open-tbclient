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
public class se3 extends re3 {
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

    @Override // com.baidu.tieba.re3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(qe3 qe3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qe3Var)) == null) {
            Bundle bundle = new Bundle();
            pe3 b = ve3.b(qe3Var.a);
            if (b == null) {
                if (!re3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = qe3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (re3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(qe3Var.c, Float.parseFloat(qe3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(qe3Var.c, qe3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(qe3Var.c, Boolean.parseBoolean(qe3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(qe3Var.c, Long.parseLong(qe3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(qe3Var.c, Integer.parseInt(qe3Var.d)));
            }
            if (re3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + qe3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
