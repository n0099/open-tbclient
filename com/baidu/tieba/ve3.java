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
public class ve3 extends ue3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ve3() {
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

    @Override // com.baidu.tieba.ue3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(te3 te3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, te3Var)) == null) {
            Bundle bundle = new Bundle();
            se3 b = ye3.b(te3Var.a);
            if (b == null) {
                if (!ue3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = te3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (ue3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(te3Var.c, Float.parseFloat(te3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(te3Var.c, te3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(te3Var.c, Boolean.parseBoolean(te3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(te3Var.c, Long.parseLong(te3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(te3Var.c, Integer.parseInt(te3Var.d)));
            }
            if (ue3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + te3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
