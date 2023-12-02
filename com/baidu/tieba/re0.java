package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class re0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract String a();

    public re0() {
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

    @CallSuper
    public boolean b(@NonNull Context context, @NonNull ve0 ve0Var, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ve0Var, map, ze0Var)) == null) {
            ez0.b((String) py0.b(ve0Var.d(), "charge_url"));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void c(ze0 ze0Var, @Nullable ve0 ve0Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ze0Var, ve0Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ef0.b(ze0Var, ve0Var, i, z);
        }
    }

    public void d(ze0 ze0Var, @Nullable ve0 ve0Var, @Nullable String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{ze0Var, ve0Var, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ef0.c(ze0Var, ve0Var, str, i, z);
        }
    }
}
