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
public class z84 extends v84<vq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948313811, "Lcom/baidu/tieba/z84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948313811, "Lcom/baidu/tieba/z84;");
                return;
            }
        }
        boolean z = tk1.a;
    }

    public z84() {
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

    public static z84 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new z84();
        }
        return (z84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v84
    public boolean b(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, vq2Var, sq2Var, j43Var, jSONObject)) == null) {
            return e(context, vq2Var, sq2Var, j43Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vq2Var, sq2Var, j43Var, jSONObject)) == null) {
            j12.i("map", "GetCenterLcationAction start");
            rq1 A = wp2.U().A(vq2Var.c);
            if (!(A instanceof pq1)) {
                j12.c("map", "WebViewManager is null");
                return false;
            }
            t94 d = s84.b().c((pq1) A).d(vq2Var.b);
            if (d == null) {
                j12.c("map", "can not find map by id " + vq2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            cr2 cr2Var = new cr2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            cr2Var.a = d2;
            cr2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", cr2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            j12.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
