package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yh3 extends wh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yh3() {
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
            uh3 b = ai3.b(vh3Var.a);
            if (b == null) {
                if (!wh3.a) {
                    return Bundle.EMPTY;
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
                                b.putFloat(vh3Var.c, Float.parseFloat(vh3Var.d));
                            }
                        } else {
                            b.putString(vh3Var.c, vh3Var.d);
                        }
                    } else {
                        b.putBoolean(vh3Var.c, Boolean.parseBoolean(vh3Var.d));
                    }
                } else {
                    b.putLong(vh3Var.c, Long.parseLong(vh3Var.d));
                }
            } else {
                b.putInt(vh3Var.c, Integer.parseInt(vh3Var.d));
            }
            if (wh3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + vh3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
