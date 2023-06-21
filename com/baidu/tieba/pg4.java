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
public class pg4 extends lg4<ly2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061068, "Lcom/baidu/tieba/pg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061068, "Lcom/baidu/tieba/pg4;");
                return;
            }
        }
        boolean z = js1.a;
    }

    public pg4() {
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

    public static pg4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new pg4();
        }
        return (pg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lg4
    public boolean b(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, ly2Var, iy2Var, zb3Var, jSONObject)) == null) {
            return e(context, ly2Var, iy2Var, zb3Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ly2Var, iy2Var, zb3Var, jSONObject)) == null) {
            z82.i("map", "GetCenterLcationAction start");
            hy1 A = mx2.T().A(ly2Var.c);
            if (!(A instanceof fy1)) {
                z82.c("map", "WebViewManager is null");
                return false;
            }
            jh4 d = ig4.b().c((fy1) A).d(ly2Var.b);
            if (d == null) {
                z82.c("map", "can not find map by id " + ly2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            sy2 sy2Var = new sy2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            sy2Var.a = d2;
            sy2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", sy2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            z82.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
