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
public class jj3 extends ij3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jj3() {
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

    @Override // com.baidu.tieba.ij3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(hj3 hj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hj3Var)) == null) {
            Bundle bundle = new Bundle();
            gj3 b = mj3.b(hj3Var.a);
            if (b == null) {
                if (!ij3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = hj3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (ij3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(hj3Var.c, Float.parseFloat(hj3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(hj3Var.c, hj3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(hj3Var.c, Boolean.parseBoolean(hj3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(hj3Var.c, Long.parseLong(hj3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(hj3Var.c, Integer.parseInt(hj3Var.d)));
            }
            if (ij3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + hj3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
