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
public class lc4 extends hc4<hu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947938060, "Lcom/baidu/tieba/lc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947938060, "Lcom/baidu/tieba/lc4;");
                return;
            }
        }
        boolean z = fo1.a;
    }

    public lc4() {
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

    public static lc4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new lc4();
        }
        return (lc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hc4
    public boolean b(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, hu2Var, eu2Var, v73Var, jSONObject)) == null) {
            return e(context, hu2Var, eu2Var, v73Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hu2Var, eu2Var, v73Var, jSONObject)) == null) {
            v42.i("map", "GetCenterLcationAction start");
            du1 A = it2.U().A(hu2Var.c);
            if (!(A instanceof bu1)) {
                v42.c("map", "WebViewManager is null");
                return false;
            }
            fd4 d = ec4.b().c((bu1) A).d(hu2Var.b);
            if (d == null) {
                v42.c("map", "can not find map by id " + hu2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            ou2 ou2Var = new ou2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            ou2Var.a = d2;
            ou2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", ou2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v42.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
