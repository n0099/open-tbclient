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
/* loaded from: classes8.dex */
public class wd4 extends sd4<sv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266722, "Lcom/baidu/tieba/wd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266722, "Lcom/baidu/tieba/wd4;");
                return;
            }
        }
        boolean z = qp1.a;
    }

    public wd4() {
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

    public static wd4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new wd4();
        }
        return (wd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd4
    public boolean b(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, sv2Var, pv2Var, g93Var, jSONObject)) == null) {
            return e(context, sv2Var, pv2Var, g93Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sv2Var, pv2Var, g93Var, jSONObject)) == null) {
            g62.i("map", "GetCenterLcationAction start");
            ov1 A = tu2.U().A(sv2Var.c);
            if (!(A instanceof mv1)) {
                g62.c("map", "WebViewManager is null");
                return false;
            }
            qe4 d = pd4.b().c((mv1) A).d(sv2Var.b);
            if (d == null) {
                g62.c("map", "can not find map by id " + sv2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            zv2 zv2Var = new zv2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            zv2Var.a = d2;
            zv2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", zv2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            g62.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
