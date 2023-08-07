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
/* loaded from: classes7.dex */
public class of4 extends kf4<kx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948030316, "Lcom/baidu/tieba/of4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948030316, "Lcom/baidu/tieba/of4;");
                return;
            }
        }
        boolean z = ir1.a;
    }

    public of4() {
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

    public static of4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new of4();
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kf4
    public boolean b(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, kx2Var, hx2Var, ya3Var, jSONObject)) == null) {
            return e(context, kx2Var, hx2Var, ya3Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, kx2Var, hx2Var, ya3Var, jSONObject)) == null) {
            y72.i("map", "GetCenterLcationAction start");
            gx1 A = lw2.T().A(kx2Var.c);
            if (!(A instanceof ex1)) {
                y72.c("map", "WebViewManager is null");
                return false;
            }
            ig4 d = hf4.b().c((ex1) A).d(kx2Var.b);
            if (d == null) {
                y72.c("map", "can not find map by id " + kx2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            rx2 rx2Var = new rx2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            rx2Var.a = d2;
            rx2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", rx2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            y72.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
