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
public class jg3 extends hg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jg3() {
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

    @Override // com.baidu.tieba.hg3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(gg3 gg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gg3Var)) == null) {
            fg3 b = lg3.b(gg3Var.a);
            if (b == null) {
                if (!hg3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = gg3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (hg3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(gg3Var.c, Float.parseFloat(gg3Var.d));
                            }
                        } else {
                            b.putString(gg3Var.c, gg3Var.d);
                        }
                    } else {
                        b.putBoolean(gg3Var.c, Boolean.parseBoolean(gg3Var.d));
                    }
                } else {
                    b.putLong(gg3Var.c, Long.parseLong(gg3Var.d));
                }
            } else {
                b.putInt(gg3Var.c, Integer.parseInt(gg3Var.d));
            }
            if (hg3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + gg3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
