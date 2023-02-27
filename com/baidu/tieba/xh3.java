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
public class xh3 extends wh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xh3() {
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

    @Override // com.baidu.tieba.wh3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(vh3 vh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vh3Var)) == null) {
            Bundle bundle = new Bundle();
            uh3 b = ai3.b(vh3Var.a);
            if (b == null) {
                if (!wh3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = vh3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (wh3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(vh3Var.c, Float.parseFloat(vh3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(vh3Var.c, vh3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(vh3Var.c, Boolean.parseBoolean(vh3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(vh3Var.c, Long.parseLong(vh3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(vh3Var.c, Integer.parseInt(vh3Var.d)));
            }
            if (wh3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + vh3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
