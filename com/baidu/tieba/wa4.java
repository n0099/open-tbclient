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
public class wa4 extends sa4<ss2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948263839, "Lcom/baidu/tieba/wa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948263839, "Lcom/baidu/tieba/wa4;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    public wa4() {
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

    public static wa4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new wa4();
        }
        return (wa4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sa4
    public boolean b(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, ss2Var, ps2Var, g63Var, jSONObject)) == null) {
            return e(context, ss2Var, ps2Var, g63Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ss2Var, ps2Var, g63Var, jSONObject)) == null) {
            g32.i("map", "GetCenterLcationAction start");
            ps1 B = tr2.V().B(ss2Var.c);
            if (!(B instanceof ns1)) {
                g32.c("map", "WebViewManager is null");
                return false;
            }
            qb4 d = pa4.b().c((ns1) B).d(ss2Var.b);
            if (d == null) {
                g32.c("map", "can not find map by id " + ss2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            zs2 zs2Var = new zs2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            zs2Var.a = d2;
            zs2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", zs2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            g32.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
