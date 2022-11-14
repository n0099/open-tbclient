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
public class v84 extends r84<rq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948194647, "Lcom/baidu/tieba/v84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948194647, "Lcom/baidu/tieba/v84;");
                return;
            }
        }
        boolean z = pk1.a;
    }

    public v84() {
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

    public static v84 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new v84();
        }
        return (v84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r84
    public boolean b(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, rq2Var, oq2Var, f43Var, jSONObject)) == null) {
            return e(context, rq2Var, oq2Var, f43Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rq2Var, oq2Var, f43Var, jSONObject)) == null) {
            f12.i("map", "GetCenterLcationAction start");
            nq1 A = sp2.U().A(rq2Var.c);
            if (!(A instanceof lq1)) {
                f12.c("map", "WebViewManager is null");
                return false;
            }
            p94 d = o84.b().c((lq1) A).d(rq2Var.b);
            if (d == null) {
                f12.c("map", "can not find map by id " + rq2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            yq2 yq2Var = new yq2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            yq2Var.a = d2;
            yq2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", yq2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f12.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
