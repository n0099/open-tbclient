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
public class sg4 extends og4<oy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948150441, "Lcom/baidu/tieba/sg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948150441, "Lcom/baidu/tieba/sg4;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public sg4() {
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

    public static sg4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new sg4();
        }
        return (sg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.og4
    public boolean b(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, oy2Var, ly2Var, cc3Var, jSONObject)) == null) {
            return e(context, oy2Var, ly2Var, cc3Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, oy2Var, ly2Var, cc3Var, jSONObject)) == null) {
            c92.i("map", "GetCenterLcationAction start");
            ky1 A = px2.T().A(oy2Var.c);
            if (!(A instanceof iy1)) {
                c92.c("map", "WebViewManager is null");
                return false;
            }
            mh4 d = lg4.b().c((iy1) A).d(oy2Var.b);
            if (d == null) {
                c92.c("map", "can not find map by id " + oy2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            vy2 vy2Var = new vy2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            vy2Var.a = d2;
            vy2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", vy2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c92.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
