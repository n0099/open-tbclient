package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m93 extends k93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m93() {
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

    @Override // com.baidu.tieba.k93
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(j93 j93Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j93Var)) == null) {
            i93 b = o93.b(j93Var.a);
            if (b == null) {
                if (!k93.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = j93Var.b;
            if (i == 1) {
                b.putInt(j93Var.c, Integer.parseInt(j93Var.d));
            } else if (i == 2) {
                b.putLong(j93Var.c, Long.parseLong(j93Var.d));
            } else if (i == 3) {
                b.putBoolean(j93Var.c, Boolean.parseBoolean(j93Var.d));
            } else if (i == 4) {
                b.putString(j93Var.c, j93Var.d);
            } else if (i != 5) {
                if (k93.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(j93Var.c, Float.parseFloat(j93Var.d));
            }
            if (k93.a) {
                Log.d("SwanAppSpDelegation", "Put: " + j93Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
