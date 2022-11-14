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
/* loaded from: classes5.dex */
public class qc3 extends pc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qc3() {
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

    @Override // com.baidu.tieba.pc3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(oc3 oc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oc3Var)) == null) {
            Bundle bundle = new Bundle();
            nc3 b = tc3.b(oc3Var.a);
            if (b == null) {
                if (!pc3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = oc3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (pc3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(oc3Var.c, Float.parseFloat(oc3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(oc3Var.c, oc3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(oc3Var.c, Boolean.parseBoolean(oc3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(oc3Var.c, Long.parseLong(oc3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(oc3Var.c, Integer.parseInt(oc3Var.d)));
            }
            if (pc3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + oc3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
