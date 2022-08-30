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
public class p54 extends l54<mn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948013018, "Lcom/baidu/tieba/p54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948013018, "Lcom/baidu/tieba/p54;");
                return;
            }
        }
        boolean z = kh1.a;
    }

    public p54() {
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

    public static p54 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new p54() : (p54) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l54
    public boolean b(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, mn2Var, jn2Var, a13Var, jSONObject)) == null) ? e(context, mn2Var, jn2Var, a13Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, mn2Var, jn2Var, a13Var, jSONObject)) == null) {
            ay1.i("map", "GetCenterLcationAction start");
            in1 A = nm2.U().A(mn2Var.c);
            if (!(A instanceof gn1)) {
                ay1.c("map", "WebViewManager is null");
                return false;
            }
            j64 d = i54.b().c((gn1) A).d(mn2Var.b);
            if (d == null) {
                ay1.c("map", "can not find map by id " + mn2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            tn2 tn2Var = new tn2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            tn2Var.a = d2;
            tn2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", tn2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ay1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
