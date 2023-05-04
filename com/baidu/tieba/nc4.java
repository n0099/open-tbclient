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
public class nc4 extends jc4<ju2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947997642, "Lcom/baidu/tieba/nc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947997642, "Lcom/baidu/tieba/nc4;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    public nc4() {
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

    public static nc4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new nc4();
        }
        return (nc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jc4
    public boolean b(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, ju2Var, gu2Var, x73Var, jSONObject)) == null) {
            return e(context, ju2Var, gu2Var, x73Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ju2Var, gu2Var, x73Var, jSONObject)) == null) {
            x42.i("map", "GetCenterLcationAction start");
            fu1 A = kt2.U().A(ju2Var.c);
            if (!(A instanceof du1)) {
                x42.c("map", "WebViewManager is null");
                return false;
            }
            hd4 d = gc4.b().c((du1) A).d(ju2Var.b);
            if (d == null) {
                x42.c("map", "can not find map by id " + ju2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            qu2 qu2Var = new qu2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            qu2Var.a = d2;
            qu2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", qu2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            x42.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
