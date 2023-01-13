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
public class uc3 extends tc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uc3() {
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

    @Override // com.baidu.tieba.tc3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(sc3 sc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sc3Var)) == null) {
            Bundle bundle = new Bundle();
            rc3 b = xc3.b(sc3Var.a);
            if (b == null) {
                if (!tc3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = sc3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (tc3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(sc3Var.c, Float.parseFloat(sc3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(sc3Var.c, sc3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(sc3Var.c, Boolean.parseBoolean(sc3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(sc3Var.c, Long.parseLong(sc3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(sc3Var.c, Integer.parseInt(sc3Var.d)));
            }
            if (tc3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + sc3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
