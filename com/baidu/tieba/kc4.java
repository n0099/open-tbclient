package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kc4 extends gc4<gu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947908269, "Lcom/baidu/tieba/kc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947908269, "Lcom/baidu/tieba/kc4;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    public kc4() {
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

    public static kc4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new kc4();
        }
        return (kc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gc4
    public boolean b(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, gu2Var, du2Var, u73Var, jSONObject)) == null) {
            return e(context, gu2Var, du2Var, u73Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gu2Var, du2Var, u73Var, jSONObject)) == null) {
            u42.i("map", "GetCenterLcationAction start");
            cu1 A = ht2.U().A(gu2Var.c);
            if (!(A instanceof au1)) {
                u42.c("map", "WebViewManager is null");
                return false;
            }
            ed4 d = dc4.b().c((au1) A).d(gu2Var.b);
            if (d == null) {
                u42.c("map", "can not find map by id " + gu2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            nu2 nu2Var = new nu2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            nu2Var.a = d2;
            nu2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", nu2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            u42.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
