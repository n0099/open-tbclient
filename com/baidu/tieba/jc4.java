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
public class jc4 extends fc4<fu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947878478, "Lcom/baidu/tieba/jc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947878478, "Lcom/baidu/tieba/jc4;");
                return;
            }
        }
        boolean z = do1.a;
    }

    public jc4() {
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

    public static jc4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new jc4();
        }
        return (jc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fc4
    public boolean b(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, fu2Var, cu2Var, t73Var, jSONObject)) == null) {
            return e(context, fu2Var, cu2Var, t73Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fu2Var, cu2Var, t73Var, jSONObject)) == null) {
            t42.i("map", "GetCenterLcationAction start");
            bu1 A = gt2.U().A(fu2Var.c);
            if (!(A instanceof zt1)) {
                t42.c("map", "WebViewManager is null");
                return false;
            }
            dd4 d = cc4.b().c((zt1) A).d(fu2Var.b);
            if (d == null) {
                t42.c("map", "can not find map by id " + fu2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            mu2 mu2Var = new mu2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            mu2Var.a = d2;
            mu2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", mu2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            t42.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
