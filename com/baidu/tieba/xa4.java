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
/* loaded from: classes9.dex */
public class xa4 extends ta4<ts2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948293630, "Lcom/baidu/tieba/xa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948293630, "Lcom/baidu/tieba/xa4;");
                return;
            }
        }
        boolean z = sm1.a;
    }

    public xa4() {
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

    public static xa4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new xa4();
        }
        return (xa4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public boolean b(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, ts2Var, qs2Var, h63Var, jSONObject)) == null) {
            return e(context, ts2Var, qs2Var, h63Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ts2Var, qs2Var, h63Var, jSONObject)) == null) {
            h32.i("map", "GetCenterLcationAction start");
            qs1 B = ur2.V().B(ts2Var.c);
            if (!(B instanceof os1)) {
                h32.c("map", "WebViewManager is null");
                return false;
            }
            rb4 d = qa4.b().c((os1) B).d(ts2Var.b);
            if (d == null) {
                h32.c("map", "can not find map by id " + ts2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            at2 at2Var = new at2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            at2Var.a = d2;
            at2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", at2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h32.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
