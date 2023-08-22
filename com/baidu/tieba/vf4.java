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
/* loaded from: classes8.dex */
public class vf4 extends pf4<px2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948238853, "Lcom/baidu/tieba/vf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948238853, "Lcom/baidu/tieba/vf4;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public vf4() {
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

    public static vf4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new vf4();
        }
        return (vf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf4
    public boolean b(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, px2Var, mx2Var, db3Var, jSONObject)) == null) {
            return e(context, px2Var, mx2Var, db3Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, px2Var, mx2Var, db3Var, jSONObject)) == null) {
            d82.i("map", "GetScaleAction start");
            lx1 A = qw2.T().A(px2Var.c);
            if (!(A instanceof jx1)) {
                d82.c("map", "WebViewManager is null");
                return false;
            }
            ng4 d = mf4.b().c((jx1) A).d(px2Var.b);
            if (d == null) {
                d82.c("map", "can not find map by id " + px2Var.b);
                return false;
            }
            try {
                jSONObject.put("scale", d.l.getMap().getMapStatus().zoom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            d82.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
