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
public class o74 extends k74<kp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985149, "Lcom/baidu/tieba/o74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985149, "Lcom/baidu/tieba/o74;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    public o74() {
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

    public static o74 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new o74() : (o74) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k74
    public boolean b(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, kp2Var, hp2Var, y23Var, jSONObject)) == null) ? e(context, kp2Var, hp2Var, y23Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, kp2Var, hp2Var, y23Var, jSONObject)) == null) {
            yz1.i("map", "GetCenterLcationAction start");
            gp1 A = lo2.U().A(kp2Var.c);
            if (!(A instanceof ep1)) {
                yz1.c("map", "WebViewManager is null");
                return false;
            }
            i84 d = h74.b().c((ep1) A).d(kp2Var.b);
            if (d == null) {
                yz1.c("map", "can not find map by id " + kp2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            rp2 rp2Var = new rp2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            rp2Var.a = d2;
            rp2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", rp2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            yz1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
