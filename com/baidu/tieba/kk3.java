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
public class kk3 extends jk3 {
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

    @Override // com.baidu.tieba.jk3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(ik3 ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ik3Var)) == null) {
            Bundle bundle = new Bundle();
            hk3 b = nk3.b(ik3Var.a);
            if (b == null) {
                if (!jk3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = ik3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (jk3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(ik3Var.c, Float.parseFloat(ik3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(ik3Var.c, ik3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(ik3Var.c, Boolean.parseBoolean(ik3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(ik3Var.c, Long.parseLong(ik3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(ik3Var.c, Integer.parseInt(ik3Var.d)));
            }
            if (jk3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + ik3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
