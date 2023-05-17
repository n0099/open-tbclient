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
/* loaded from: classes8.dex */
public class zd4 extends sd4<rv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948356095, "Lcom/baidu/tieba/zd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948356095, "Lcom/baidu/tieba/zd4;");
                return;
            }
        }
        boolean z = qp1.a;
    }

    public zd4() {
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

    public static zd4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new zd4();
        }
        return (zd4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sd4
    /* renamed from: d */
    public boolean b(Context context, rv2 rv2Var, pv2 pv2Var, g93 g93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rv2Var, pv2Var, g93Var, jSONObject)) == null) {
            return f(context, rv2Var, pv2Var, g93Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, rv2 rv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, rv2Var, pv2Var, g93Var)) == null) {
            g62.i("map", "IncludePointsAction start");
            ov1 A = tu2.U().A(rv2Var.c);
            if (!(A instanceof mv1)) {
                g62.c("map", "WebViewManager is null");
                return false;
            }
            qe4 d = pd4.b().c((mv1) A).d(rv2Var.b);
            if (d == null) {
                g62.c("map", "can not find map by id " + rv2Var.b);
                return false;
            }
            g62.i("map", "IncludePointsAction end");
            return g(rv2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(rv2 rv2Var, qe4 qe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, rv2Var, qe4Var)) == null) {
            if (rv2Var == null || !rv2Var.isValid()) {
                return false;
            }
            BaiduMap map = qe4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<zv2> it = rv2Var.z.iterator();
            while (it.hasNext()) {
                zv2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = rv2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
