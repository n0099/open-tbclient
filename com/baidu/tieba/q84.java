package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class q84<T extends qq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean b(Context context, T t, nq2 nq2Var, e43 e43Var, JSONObject jSONObject);

    public q84() {
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

    public boolean c(Context context, T t, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, t, nq2Var, e43Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!b(context, t, nq2Var, e43Var, jSONObject)) {
                nq2Var.d(1001);
                e12.c("map", "doAction fail");
                return false;
            }
            if (jSONObject.length() <= 0) {
                jSONObject = null;
            }
            nq2Var.e(jSONObject);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
