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
/* loaded from: classes7.dex */
public class oj3 extends nj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oj3() {
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

    @Override // com.baidu.tieba.nj3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(mj3 mj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mj3Var)) == null) {
            Bundle bundle = new Bundle();
            lj3 b = rj3.b(mj3Var.a);
            if (b == null) {
                if (!nj3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = mj3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (nj3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(mj3Var.c, Float.parseFloat(mj3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(mj3Var.c, mj3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(mj3Var.c, Boolean.parseBoolean(mj3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(mj3Var.c, Long.parseLong(mj3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(mj3Var.c, Integer.parseInt(mj3Var.d)));
            }
            if (nj3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + mj3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
