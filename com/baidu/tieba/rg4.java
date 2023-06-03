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
/* loaded from: classes7.dex */
public class rg4 extends kg4<jy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948120650, "Lcom/baidu/tieba/rg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948120650, "Lcom/baidu/tieba/rg4;");
                return;
            }
        }
        boolean z = is1.a;
    }

    public rg4() {
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

    public static rg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new rg4();
        }
        return (rg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4
    /* renamed from: d */
    public boolean b(Context context, jy2 jy2Var, hy2 hy2Var, yb3 yb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jy2Var, hy2Var, yb3Var, jSONObject)) == null) {
            return f(context, jy2Var, hy2Var, yb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, jy2 jy2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jy2Var, hy2Var, yb3Var)) == null) {
            y82.i("map", "IncludePointsAction start");
            gy1 A = lx2.T().A(jy2Var.c);
            if (!(A instanceof ey1)) {
                y82.c("map", "WebViewManager is null");
                return false;
            }
            ih4 d = hg4.b().c((ey1) A).d(jy2Var.b);
            if (d == null) {
                y82.c("map", "can not find map by id " + jy2Var.b);
                return false;
            }
            y82.i("map", "IncludePointsAction end");
            return g(jy2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(jy2 jy2Var, ih4 ih4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jy2Var, ih4Var)) == null) {
            if (jy2Var == null || !jy2Var.isValid()) {
                return false;
            }
            BaiduMap map = ih4Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<ry2> it = jy2Var.z.iterator();
            while (it.hasNext()) {
                ry2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = jy2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
