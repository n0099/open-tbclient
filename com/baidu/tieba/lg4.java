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
/* loaded from: classes6.dex */
public class lg4 extends hg4<hy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947941904, "Lcom/baidu/tieba/lg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947941904, "Lcom/baidu/tieba/lg4;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public lg4() {
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

    public static lg4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new lg4();
        }
        return (lg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hg4
    public boolean b(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, hy2Var, ey2Var, vb3Var, jSONObject)) == null) {
            return e(context, hy2Var, ey2Var, vb3Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hy2Var, ey2Var, vb3Var, jSONObject)) == null) {
            v82.i("map", "GetCenterLcationAction start");
            dy1 A = ix2.T().A(hy2Var.c);
            if (!(A instanceof by1)) {
                v82.c("map", "WebViewManager is null");
                return false;
            }
            fh4 d = eg4.b().c((by1) A).d(hy2Var.b);
            if (d == null) {
                v82.c("map", "can not find map by id " + hy2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            oy2 oy2Var = new oy2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            oy2Var.a = d2;
            oy2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", oy2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v82.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
