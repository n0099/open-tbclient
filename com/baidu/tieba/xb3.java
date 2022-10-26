package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xb3 extends wb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xb3() {
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

    @Override // com.baidu.tieba.wb3
    public Bundle c(vb3 vb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vb3Var)) == null) {
            Bundle bundle = new Bundle();
            ub3 b = ac3.b(vb3Var.a);
            if (b == null) {
                if (!wb3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = vb3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (wb3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(vb3Var.c, Float.parseFloat(vb3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(vb3Var.c, vb3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(vb3Var.c, Boolean.parseBoolean(vb3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(vb3Var.c, Long.parseLong(vb3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(vb3Var.c, Integer.parseInt(vb3Var.d)));
            }
            if (wb3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + vb3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
