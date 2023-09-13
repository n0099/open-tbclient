package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zf4 extends tf4<tx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948358017, "Lcom/baidu/tieba/zf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948358017, "Lcom/baidu/tieba/zf4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public zf4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static zf4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new zf4();
        }
        return (zf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tf4
    public boolean b(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            return e(context, tx2Var, qx2Var, hb3Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            h82.i("map", "GetScaleAction start");
            px1 A = uw2.T().A(tx2Var.c);
            if (!(A instanceof nx1)) {
                h82.c("map", "WebViewManager is null");
                return false;
            }
            rg4 d = qf4.b().c((nx1) A).d(tx2Var.b);
            if (d == null) {
                h82.c("map", "can not find map by id " + tx2Var.b);
                return false;
            }
            try {
                jSONObject.put("scale", d.l.getMap().getMapStatus().zoom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h82.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
