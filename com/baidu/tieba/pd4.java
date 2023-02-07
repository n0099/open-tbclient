package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pd4 extends id4<hv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948058185, "Lcom/baidu/tieba/pd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948058185, "Lcom/baidu/tieba/pd4;");
                return;
            }
        }
        boolean z = gp1.a;
    }

    public pd4() {
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

    public static pd4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new pd4();
        }
        return (pd4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.id4
    /* renamed from: d */
    public boolean b(Context context, hv2 hv2Var, fv2 fv2Var, w83 w83Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hv2Var, fv2Var, w83Var, jSONObject)) == null) {
            return f(context, hv2Var, fv2Var, w83Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, hv2 hv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, hv2Var, fv2Var, w83Var)) == null) {
            w52.i("map", "IncludePointsAction start");
            ev1 A = ju2.U().A(hv2Var.c);
            if (!(A instanceof cv1)) {
                w52.c("map", "WebViewManager is null");
                return false;
            }
            ge4 d = fd4.b().c((cv1) A).d(hv2Var.b);
            if (d == null) {
                w52.c("map", "can not find map by id " + hv2Var.b);
                return false;
            }
            w52.i("map", "IncludePointsAction end");
            return g(hv2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(hv2 hv2Var, ge4 ge4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hv2Var, ge4Var)) == null) {
            if (hv2Var == null || !hv2Var.isValid()) {
                return false;
            }
            BaiduMap map = ge4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<pv2> it = hv2Var.z.iterator();
            while (it.hasNext()) {
                pv2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = hv2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
