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
/* loaded from: classes4.dex */
public class jb3 extends ib3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jb3() {
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

    @Override // com.baidu.tieba.ib3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(hb3 hb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hb3Var)) == null) {
            Bundle bundle = new Bundle();
            gb3 b = mb3.b(hb3Var.a);
            if (b == null) {
                if (ib3.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = hb3Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(hb3Var.c, Integer.parseInt(hb3Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(hb3Var.c, Long.parseLong(hb3Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(hb3Var.c, Boolean.parseBoolean(hb3Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(hb3Var.c, hb3Var.d));
            } else if (i != 5) {
                if (ib3.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(hb3Var.c, Float.parseFloat(hb3Var.d)));
            }
            if (ib3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + hb3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
